package ru.itis.informatics.lab08;

public class Main {
	public static void main(String[] args) throws Exception {
		final double[][] argument = new double[][]{
						{1, 2, 3, 4},
						{-3, 2, -5, 13},
						{1, -2, 10, 4},
						{-2, 9, -8, 25}
		};

		final Matrix actual = new Matrix(argument);

		actual.makeTriangular();
		
		System.out.println(actual.determinant());

		System.out.println(actual);
	}
}