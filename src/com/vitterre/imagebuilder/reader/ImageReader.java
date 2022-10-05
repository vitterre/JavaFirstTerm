package com.vitterre.imagebuilder.reader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Implements methods of {@code ImageReader} that
 * allow to read BMP image and get pixels from it.
 * See {@link ImageReader}.
 */
public class ImageReader {
	/**
	 * Implements logic of image reading
	 * and gives all information about
	 * each pixel. Example:
	 * <p>
	 * {@code
	 * [[(), (), ()],}
	 * </p>
	 * <p>
	 * {@code
	 * [(), (), ()], }
	 * </p>
	 * <p>
	 * {@code
	 * [(), (), ()]] }
	 * </p>
	 * <p>
	 * This is an example of storing 3x3 image.
	 * X equals 3 and Y equals 3. Each {@code ()}
	 * contains 3 elements: RED value, GREEN value
	 * and BLUE value.
	 * </p>
	 * @param path file path
	 * @return 3rd dimensional array that
	 * contains RGB values of each pixel
	 * @throws IOException if occur some
	 * troubles with file reading
	 */
	public int[][][] readFile(String path) throws IOException {
		// Reading an image
		File imageFile = new File(path);
		BufferedImage bufferedImage = ImageIO.read(imageFile);

		// Getting basic information of image
		final int imageHeight = bufferedImage.getHeight();
		final int imageWidth = bufferedImage.getWidth();

		// Creating array that will contain image data
		final int[][][] imageData = new int[imageHeight][imageWidth][3];

		// Reading information of each pixel
		for (int y = 0; y < imageHeight; ++y) {
			for (int x = 0; x < imageWidth; ++x) {
				// Retrieving contents of a pixel
				int pixel = bufferedImage.getRGB(x, y);
				// Creating a color object from pixel value
				Color color = new Color(pixel, true);
				// Storing in each pixel his RGB value
				imageData[y][x][0] = color.getAlpha() == 0 ? 200 : color.getRed();
				imageData[y][x][1] = color.getAlpha() == 0 ? 200 : color.getGreen();
				imageData[y][x][2] = color.getAlpha() == 0 ? 200 : color.getBlue();
			}
		}

		return imageData;
	}
}
