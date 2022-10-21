package ru.itis.informatics.lab08;

public class Main {
	public static void main(String[] args) {
		MatrixNxM A = new MatrixNxM(2, 2, new double[][]{{1, 1}, {1, 1}});
		MatrixNxM B = new MatrixNxM(2, 2, new double[][]{{2, 2}, {2, 2}});
		System.out.println(A.multiply(20));
	}
}