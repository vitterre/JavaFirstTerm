package com.vitterre.tasks;

public class TreeForce {
	/**
	 * # 01
	 * Builds treeforce of three triangles.
	 * @param n amount of triangle layers
	 */
	public static void build(final int n) {
		for (int i = 0; i < n; ++i) {
			for (int l = 0; l < 2 * n - i; ++l) {
				System.out.print(" ");
			}

			for (int l = 0; l < 2 * i + 1; ++l) {
				System.out.print("*");
			}

			for (int l = 0; l < 2 * n - i; ++l) {
				System.out.print(" ");
			}

			System.out.println();
		}

		for (int i = 0; i < n; ++i) {
			for (int l = 0; l < n - 1 - i; ++l) {
				System.out.print(" ");
			}

			for (int l = 0; l < 2 * i + 1; ++l) {
				System.out.print("*");
			}

			for (int l = 0; l < 2 * n - 2 * i + 1; ++l) {
				System.out.print(" ");
			}

			for (int l = 0; l < 2 * i + 1; ++l) {
				System.out.print("*");
			}

			for (int l = 0; l < n - 1 - i; ++l) {
				System.out.print(" ");
			}

			System.out.println();
		}
	}
}
