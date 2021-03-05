import numpy as np
from PIL import Image
import matplotlib.pyplot as plt
import math


################################################################################
def convert_to_gray_scale_arr(filename):
    image_gray = Image.open(filename).convert('RGB').convert('L')
    gray_scale = np.array(image_gray)
    return image_gray.width, image_gray.height, gray_scale


################################################################################
def from_gray_to_3_channel(width, height, image_data):
    output = np.zeros((height, width, 3), dtype=int)
    for y in range(height):
        for x in range(width):
            rgb = [image_data[y][x], image_data[y][x], image_data[y][x]]
            output[y][x] = rgb
    return output


################################################################################
def make_matrix(values, size):
    matrix_out = np.zeros((size, size), dtype=int)
    i = 0
    for fx in range(size):
        for fy in range(size):
            matrix_out[fx][fy] = values[i]
            i = i + 1
        pass
    pass
    return matrix_out


################################################################################
def convolve_square(kernel, window, size):
    sum = 0
    for fx in range(size):
        for fy in range(size):
            sum = sum + kernel[fx][fy] * window[fx][fy]
    return sum


################################################################################
def compute_derivatives(window, size):
    gx = np.array([[-1, 0, 1], [-2, 0, 2], [-1, 0, 1]], np.int)
    gy = np.array([[-1, -2, -1], [0, 0, 0], [1, 2, 1]], np.int)

    s1 = convolve_square(window, gx, size)
    s2 = convolve_square(window, gy, size)
    magnitude = int(math.sqrt(s1 * s1 + s2 * s2))
    return magnitude


################################################################################
def zero_padding(x, y, width, height):
    pad = False
    if x < 0:
        x = 0
        pad = True

    if x >= width:
        x = width - 1
        pad = True

    if y < 0:
        y = 0
        pad = True

    if y >= height:
        y = height - 1
        pad = True

    return pad, x, y


################################################################################
def normalize_image(width, height, image_data, max_magnitude):
    threshold = float(0.05)
    for fx in range(width):
        print("normalizing " + str(fx) + " of " + str(range(width)))
        for fy in range(height):
            color_normalized = (image_data[fx][fy] / max_magnitude)
            if color_normalized < threshold:
                color_normalized = float(0)
            image_data[fx][fy] = int(color_normalized * 255)

    return image_data


################################################################################
def sobel_filter(width, height, image_data):
    kernel_size = 3
    window = np.zeros((kernel_size, kernel_size), dtype=int)
    output_image = np.zeros((height, width), dtype=int)
    edge_x = int(kernel_size / 2)
    edge_y = int(kernel_size / 2)
    out_x = out_y = 0
    max_magnitude = int(0)
    for x in range(width - edge_x + 1):
        print("processing " + str(x) + " of " + str(width - edge_x + 1))
        for y in range(height - edge_y + 1):
            i = 0
            for fx in range(kernel_size):
                for fy in range(kernel_size):
                    x_image = x + fx - edge_x
                    y_image = y + fy - edge_y

                    # zero padding
                    pad, x_image, y_image = zero_padding(x_image, y_image, width, height)
                    if pad:
                        window[fx][fy] = 0
                    else:
                        window[fx][fy] = image_data[x_image][y_image]
                    pass

                    i = i + 1
                pass
            # print(window)
            magnitude = compute_derivatives(window, kernel_size)
            if magnitude > max_magnitude:
                max_magnitude = magnitude
            output_image[out_y][out_x] = magnitude
            out_x = out_x + 1
            # print("\n")
        pass
        out_x = 0
        out_y = out_y + 1
        # print("----\n")
    pass

    # normalize image
    normalized = normalize_image(width, height, output_image, max_magnitude)

    return normalized


################################################################################
def test():
    [width, height, image_data] = convert_to_gray_scale_arr("pic1.png")
    image_edges = sobel_filter(width, height, image_data)

    src_image = from_gray_to_3_channel(width, height, image_data)
    dest_image = from_gray_to_3_channel(width, height, image_edges)

    fig = plt.figure()
    ax1 = fig.add_subplot(1, 2, 1)
    ax1.imshow(src_image)

    ax2 = fig.add_subplot(1, 2, 2)
    ax2.imshow(dest_image)

    plt.show()


################################################################################
test()
