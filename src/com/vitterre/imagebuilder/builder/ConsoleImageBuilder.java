package com.vitterre.imagebuilder.builder;

import com.vitterre.imagebuilder.reader.ImageReader;
import java.io.IOException;

/**
 * This class contains methods that
 * allow to build console image from
 * file (.png, .bmp etc).
 */
public class ConsoleImageBuilder {
	/**
	 * Builds and outputs console image.
	 * @param path file path
	 * @throws IOException if occur some
	 * troubles with file reading
	 */
	public void build(final String path) throws IOException {
		ImageReader imageReader = new ImageReader();
		final int[][][] imageData = imageReader.readFile(path);

		for (int i = 0; i < imageData.length; ++i) {
			for (int j = 0; j < imageData[0].length; ++j) {
				System.out.printf("\u001B[38;2;%d;%d;%dm",
								imageData[i][j][0],
								imageData[i][j][1],
								imageData[i][j][2]);
				System.out.print("\u2588");
				System.out.print("\u001B[0m");
			}
			System.out.println();
		}
	}
}
