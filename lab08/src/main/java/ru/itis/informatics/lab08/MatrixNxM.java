package ru.itis.informatics.lab08;

public class MatrixNxM {
	private final int n;
	private final int m;
	private final double[][] matrix;

	public MatrixNxM(int n, int m) {
		this.n = n;
		this.m = m;
		matrix = new double[m][n];
	}

	public MatrixNxM(int n, int m, double[][] matrix) {
		this.n = n;
		this.m = m;
		this.matrix = matrix;
	}

	public void toZero() {
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				matrix[i][j] = 0;
			}
		}
	}

	public int getN() {
		return n;
	}

	public int getM() {
		return m;
	}

	public double[][] getMatrix() {
		return matrix;
	}

	@Override
	public String toString() {
		StringBuilder matrixOutput = new StringBuilder();

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (j == 0) {
					matrixOutput.append("|| ").append(matrix[i][j]);
				} else if (j == m - 1) {
					matrixOutput.append(" ").append(matrix[i][j]).append(" ||");
				} else {
					matrixOutput.append(" ").append(matrix[i][j]);
				}

			}
			if (i != n - 1) {
				matrixOutput.append("\n");
			}
		}

		return matrixOutput.toString();
	}

	MatrixNxM plus(MatrixNxM otherMatrix) {
		if (otherMatrix == null) {
			return null;
		}

		if (n != otherMatrix.getN() || m != otherMatrix.getN()) {
			return null;
		}

		final double[][] otherMatrixValues = otherMatrix.getMatrix();
		final double[][] newMatrixValues = new double[m][n];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				newMatrixValues[i][j] = matrix[i][j] + otherMatrixValues[i][j];
			}
		}

		return new MatrixNxM(n, m, newMatrixValues);
	}

	MatrixNxM minus(MatrixNxM otherMatrix) {
		return plus(otherMatrix.multiply(-1));
	}

	MatrixNxM multiply(final double number) {
		final double[][] newMatrixValues = new double[m][n];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				newMatrixValues[i][j] = number * matrix[i][j];
			}
		}

		return new MatrixNxM(n, m, newMatrixValues);
	}
}
