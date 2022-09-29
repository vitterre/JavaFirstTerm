package com.vitterre.tasks;

public class CircleBuilder {
	/**
	 * Checks that symbol is in the circle.
	 * @param r radius
	 * @param x col (j)
	 * @param y row (i)
	 * @return is symbol in the circle
	 */
	private static boolean isSymbolInTheCircle(int r, int x, int y) {
		var xdot = x - r;
		var ydot = y - r;

		return xdot * xdot + ydot * ydot < r * r;
	}

	/**
	 * # 04
	 * Builds circle.
	 * @param n diameter
	 */
	public static void build(int n) {
		for (int i = 0; i <= n; ++i) {
			for (int j = 0; j <= n; ++j) {
				if (isSymbolInTheCircle(n / 2, i, j)) {
					System.out.print("0");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
