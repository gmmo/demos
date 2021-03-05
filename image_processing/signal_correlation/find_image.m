clear;
clc;

src_image = im2gray(imread('all_coins.png'));
search_image = im2gray(imread('coin.png'));

correlation_surface = normxcorr2(search_image,src_image);
surf(correlation_surface)
shading flat

% two matches
% threshold = 0.60;

% single matche
threshold  = 0.98;

[y_peak, x_peak] = find( correlation_surface >= threshold * max(correlation_surface(:)));

y_matches = y_peak-size(search_image,1);
x_matches = x_peak-size(search_image,2);

figure;
imshow(search_image);

figure;
imshow(src_image);

for i=1:length(x_matches)
    imrect(gca, [x_matches(i)+1, y_matches(i)+1, size(search_image,2), size(search_image,1)]);
    hold on;
end
