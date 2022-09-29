public class Main {
	public static void main(String[] args) {
		// HW: Draw golden apple :D
		int[][][] image = {
						{       {255,   0, 100, 255},
										{200, 200, 200, 200},
										{  0,   0,   0, 100},
										{200, 100,  40,  30}, /* LINES */}, // RED
						{       {255,  20, 100, 200},
										{100,   0,   0, 200},
										{ 10, 100,   0, 200},
										{120, 255, 255,   0}  /* LINES */}, // GREEN
						{       {255,   0, 200, 200},
										{120, 240,   0,   0},
										{255,   0, 100,   0},
										{100, 120,   0,   0}  /* LINES */}  // BLUE
		};

		final String RESET = "\u001B[0m";
		final String RGB = "\u001B[38;2;255;200;255m";
		final String R = "\u2588";

		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				System.out.printf("\u001B[38;2;%d;%d;%dm", image[0][i][j], image[1][i][j], image[2][i][j]);
				System.out.print(R);
				System.out.print(RESET);
			}
			System.out.println();
		}
	}
}