package ru.itis.informatics.lab08;

public class MatrixNxM {
	private final int n;
	private final int m;
	private final double[][] matrix;
	private int determinantSign = 1;

	public MatrixNxM(int n, int m) {
		this.n = n;
		this.m = m;
		this.matrix = new double[m][n];
	}

	public MatrixNxM(double[][] matrix) throws Exception {
		this.m = matrix.length;
		this.n = matrix[0].length;
		this.matrix = matrix;
		if (!validateCheck(matrix)) {
			throw new Exception("Array that you have given as an argument is not a rectangle!");
		}
	}

	public MatrixNxM(int n, int m, double[][] matrix) throws Exception {
		this.n = n;
		this.m = m;
		this.matrix = matrix;
		if (!validateCheck(matrix)) {
			throw new Exception("Array that you have given as an argument is not a rectangle!");
		}
	}


	public static boolean validateCheck(MatrixNxM matrixNxM) {
		return validateCheck(matrixNxM.getMatrix());
	}

	public static boolean validateCheck(double[][] matrixNxM) {
		final int n = matrixNxM[0].length;

		for (double[] rows : matrixNxM) {
			if (rows.length != n) {
				return false;
			}
		}

		return true;
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

	public int getDeterminantSign() {
		return determinantSign;
	}

	@Override
	public String toString() {
		StringBuilder matrixOutput = new StringBuilder();

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (j == 0) {
					matrixOutput.append("|| ").append(matrix[i][j]);
				} else if (j == n - 1) {
					matrixOutput.append(" ").append(matrix[i][j]).append(" ||");
				} else {
					matrixOutput.append(" ").append(matrix[i][j]);
				}
			}

			if (i != m - 1) {
				matrixOutput.append("\n");
			}
		}

		return matrixOutput.toString();
	}

	MatrixNxM plus(MatrixNxM otherMatrix) throws Exception {
		if (otherMatrix == null) {
			return null;
		}

		if (n != otherMatrix.getN() || m != otherMatrix.getM()) {
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

	MatrixNxM minus(MatrixNxM otherMatrix) throws Exception {
		return plus(otherMatrix.multiply(-1));
	}

	MatrixNxM multiply(final double number) throws Exception {
		final double[][] newMatrixValues = new double[m][n];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				newMatrixValues[i][j] = number * matrix[i][j];
			}
		}

		return new MatrixNxM(n, m, newMatrixValues);
	}

	public MatrixNxM multiply(MatrixNxM otherMatrix) throws Exception {
		if (m != otherMatrix.getN()) {
			throw new Exception(
							"The amount of cols of the first matrix doesn't equal to the amount of rows of the second matrix!"
			);
		}

		double[][] result = new double[m][m];
		double[][] otherMatrixValues = otherMatrix.getMatrix();

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < otherMatrix.getN(); ++j) {
				double sum = 0;
				for (int k = 0; k < n; ++k) {
					sum += matrix[i][k] * otherMatrixValues[k][j];
				}
				result[i][j] = sum;
			}
		}

		return new MatrixNxM(result);
	}

	public void replaceCol(int first, int second) {
		if (first != second) {
			determinantSign *= -1;
		}

		double[][] tempCol = new double[m][1];

		for (int i = 0; i < m; ++i) {
			tempCol[i][0] = matrix[i][first - 1];
			matrix[i][first - 1] = matrix[i][second - 1];
			matrix[i][second - 1] = tempCol[i][0];
		}
	}

	public void replaceRow(int first, int second) {
		if (first != second) {
			determinantSign *= -1;
		}

		double[][] tempRow = new double[1][n];

		for (int i = 0; i < n; ++i) {
			tempRow[0][i] = matrix[first - 1][i];
			matrix[first - 1][i] = matrix[second - 1][i];
			matrix[second - 1][i] = tempRow[0][i];
		}
	}

	public void sortRow(int row) {
		for (int i = n - 1; i >= row; --i) {
			for (int k = n - 1; k >= row; --k) {
				if (matrix[row - 1][i] < matrix[row - 1][k]) {
					replaceCol(i, k);
				}
			}
		}
	}

	public void sortCol(int col) {
		for (int i = m - 1; i >= col; --i) {
			for (int k = m - 1; k >= col; --k) {
				if (Math.abs(matrix[i][col - 1]) < Math.abs(matrix[k][col - 1])) {
					replaceRow(i, k);
				}
			}
		}
	}

	public void multiplyCol(int col, double number) {
		if (number < 0) {
			determinantSign *= -1;
		}

		for (int i = 0; i < m; ++i) {
			matrix[i][col - 1] *= number;
		}
	}

	public void multiplyRow(int row, double number) {
		if (number < 0) {
			determinantSign *= -1;
		}

		for (int j = 0; j < n; ++j) {
			matrix[row][j] *= number;
		}
	}
}
