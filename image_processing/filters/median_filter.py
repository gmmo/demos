import numpy as np
from PIL import Image
import matplotlib.pyplot as plt


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
def median_filter(width, height, image_data):
    kernel_size = 3
    mid_point = int((kernel_size * kernel_size) / 2)
    window = np.zeros((kernel_size * kernel_size), dtype=int)
    window_debug = np.zeros((kernel_size, kernel_size), dtype=int)
    output_image = np.zeros((height, width), dtype=int)
    edge_x = int(kernel_size / 2)
    edge_y = int(kernel_size / 2)
    out_x = out_y = 0
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
                        window[i] = 0
                    else:
                        window[i] = image_data[x_image][y_image]
                    pass

                    window_debug[fx][fy] = window[i]

                    i = i + 1
                pass
            # print(window_debug)
            sorted_values = np.sort(window)
            median = sorted_values[mid_point]
            # print(sorted_values)
            # print(median)
            output_image[out_y][out_x] = median
            out_x = out_x + 1
            # print("\n")
        pass
        out_x = 0
        out_y = out_y + 1
        # print("----\n")
    pass

    return output_image


################################################################################
def test():
    [width, height, image_data] = convert_to_gray_scale_arr("pic1_noisy.png")
    filtered = median_filter(width, height, image_data)
    filtered2 = median_filter(width, height, filtered)

    src_image = from_gray_to_3_channel(width, height, image_data)
    filtered_image = from_gray_to_3_channel(width, height, filtered)
    filtered_image2 = from_gray_to_3_channel(width, height, filtered2)

    fig = plt.figure()
    ax1 = fig.add_subplot(1, 3, 1)
    ax1.imshow(src_image)

    ax2 = fig.add_subplot(1, 3, 2)
    ax2.imshow(filtered_image)

    ax3 = fig.add_subplot(1, 3, 3)
    ax3.imshow(filtered_image2)

    plt.show()


test()
