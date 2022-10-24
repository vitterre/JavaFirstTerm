package ru.itis.informatics.lab08;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		Matrix matrix = new Matrix(new double[][]{
			// {20, 120, 4},
			{1, 2, 3},
			{4, 10, 6},
			{7, 8, 9},
			{9, 5, 3}
		});
		System.out.println(matrix + "\n");
		matrix.sortCol(2);
		System.out.println(matrix);
	}
}