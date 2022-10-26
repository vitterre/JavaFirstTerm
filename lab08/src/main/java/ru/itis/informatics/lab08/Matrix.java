package ru.itis.informatics.lab08;

import java.util.Arrays;

/**
 * <p>
 * <b>Matrix</b> - a rectangular table of numbers that
 * contains {@code m} rows and {@code n} columns. The
 * numbers {@code m} and {@code n} are called matrix
 * orders. If {@code m == n}, the matrix is called
 * square, and the number {@code m = n} is its order.
 * </p>
 * <p>
 * But keep in mind that in this implementation of
 * matrix all indexes start from <b>zero</b> to {@code m}
 * or {@code n}.
 * </p>
 */
public final class Matrix {

	/**
	 * The number of <b>columns</b>.
	 */
	private int n;

	/**
	 * The number of <b>rows</b>.
	 */
	private int m;

	/**
	 * <b>Determinant</b> - a numerical characteristic
	 * corresponding to each matrix. It can change its
	 * character relative to the <b>determinant operation</b>.
	 */
	private int determinantSign = 1;

	/**
	 * In this case, the matrix is a <b>two-dimensional
	 * array</b> where all inner arrays are equal in length.
	 */
	private double[][] matrix;

	/**
	 * Creates a new instance of {@code Matrix} based on
	 * the number of rows {@code m} and columns {@code n}
	 * and fills a two-dimensional array with zeros.
	 *
	 * @param n Columns
	 * @param m Rows
	 */
	public Matrix(final int n, final int m) {
		this.n = n;
		this.m = m;
		this.matrix = new double[m][n];
	}

	/**
	 * Creates a new instance of {@code Matrix} based on
	 * two-dimensional array. Also, it calculates {@code m}
	 * and {@code n}.
	 *
	 * @param matrix Array
	 * @throws Exception If two-dimensional array is not a
	 *                   rectangle
	 */
	public Matrix(final double[][] matrix) throws Exception {
		if (validate(matrix)) {
			this.n = matrix[0].length;
			this.m = matrix.length;
			this.matrix = Arrays.copyOf(matrix, matrix.length);
		}
	}

	/**
	 * Creates a new instance of {@code Matrix} based on
	 * the number of rows {@code m}, the number of columns
	 * {@code n} and, of course, the two-dimensional array.
	 *
	 * @param n      Columns
	 * @param m      Rows
	 * @param matrix Array
	 * @throws Exception If two-dimensional array is not a
	 *                   rectangle
	 */
	public Matrix(final int n, final int m, final double[][] matrix) throws Exception {
		if (validate(matrix) && m == matrix.length && n == matrix[0].length) {
			this.n = n;
			this.m = m;
			this.matrix = Arrays.copyOf(matrix, matrix.length);
		}
	}

	/**
	 * This method checks whether a two-dimensional array
	 * passed as an argument is a matrix.
	 *
	 * @param matrixForValidating Two-dimensional array
	 * @return {@code true} if an array is a rectangle
	 * @throws Exception Otherwise
	 */
	public static boolean validate(final double[][] matrixForValidating) throws Exception {
		for (int i = 0; i < matrixForValidating.length; ++i) {
			for (int j = 0; j < matrixForValidating.length; ++j) {
				if (matrixForValidating[i].length != matrixForValidating[j].length) {
					throw new Exception(
									"The two-dimensional array you passed as an argument is not a rectangle!"
					);
				}
			}
		}

		return true;
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

	/**
	 * Resets the entire matrix.
	 */
	public void toZero() {
		this.matrix = new double[m][n];
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

	/**
	 * Changes two columns of the matrix in places.
	 *
	 * @param current The number of the original column
	 * @param to      The number of the column to replace
	 *                the original column
	 */
	public void replaceCol(final int current, final int to) {
		final double[][] tempCol = new double[m][1];
		determinantSign *= -1;

		for (int i = 0; i < m; ++i) {
			tempCol[i][0] = matrix[i][current];
			matrix[i][current] = matrix[i][to];
			matrix[i][to] = tempCol[i][0];
		}
	}

	/**
	 * Changes two rows of the matrix in places.
	 *
	 * @param current The number of the original row
	 * @param to      The number of the row to replace
	 *                the original row
	 */
	public void replaceRow(final int current, final int to) {
		final double[][] tempRow = new double[1][n];
		determinantSign *= -1;

		for (int j = 0; j < n; ++j) {
			tempRow[0][j] = matrix[current][j];
			matrix[current][j] = matrix[to][j];
			matrix[to][j] = tempRow[0][j];
		}
	}

	/**
	 * Sorts the specified matrix column.
	 *
	 * @param col The column number to be sorted
	 */
	public void sortCol(final int col) {
		for (int i = 0; i < m; ++i) {
			for (int k = 0; k < m; ++k) {
				if (matrix[i][col] < matrix[k][col]) {
					replaceRow(i, k);
				}
			}
		}
	}

	/**
	 * Sorts the specified matrix row.
	 *
	 * @param row The row number to be sorted
	 */
	public void sortRow(final int row) {
		for (int i = 0; i < n; ++i) {
			for (int k = 0; k < n; ++k) {
				if (matrix[row][i] < matrix[row][k]) {
					replaceCol(i, k);
				}
			}
		}
	}

	/**
	 * Adds one row to the other.
	 *
	 * @param first  The number of the row to which
	 *               the other row is added
	 * @param second The number of the row that is
	 *               added to the other row
	 */
	public void addRow(final int first, final int second) {
		for (int j = 0; j < n; ++j) {
			matrix[first][j] += matrix[second][j];
		}
	}

	/**
	 * Adds one column to the other.
	 *
	 * @param first  The number of the column to which
	 *               the other column is added
	 * @param second The number of the column that is
	 *               added to the other column
	 */
	public void addCol(final int first, final int second) {
		for (int i = 0; i < m; ++i) {
			matrix[i][first] += matrix[i][second];
		}
	}

	/**
	 * Multiplies a row by a real number.
	 *
	 * @param row    The row to be multiplied
	 * @param number The number by which the row is
	 *               multiplied
	 */
	public void multiplyRow(final int row, final double number) {
		for (int j = 0; j < n; ++j) {
			matrix[row][j] *= number;
		}
	}

	/**
	 * Multiplies a column by a real number.
	 *
	 * @param col    The column to be multiplied
	 * @param number The number by which the column
	 *               is multiplied
	 */
	public void multiplyCol(final int col, final double number) {
		for (int i = 0; i < m; ++i) {
			matrix[i][col] *= number;
		}
	}

	/**
	 * Converts the matrix to a stepped form.
	 *
	 * @throws Exception If the matrix is not a square
	 */
	public void makeTriangular() throws Exception {
		if (validateSquaredMatrix()) {
			throw new Exception("Matrix is not a square!");
		}

		for (int k = 0; k < n; ++k) {
			int max = k;
			for (int i = k + 1; i < n; ++i) {
				if (matrix[i][k] > matrix[max][k]) {
					max = i;
				}
			}

			replaceRow(k, max);

			for (int i = k + 1; i < n; ++i) {
				final double factor = matrix[i][k] / matrix[k][k];
				for (int j = k; j < n; ++j) {
					matrix[i][j] -= factor * matrix[k][j];
				}
			}
		}
	}

	/**
	 * Multiplies the main diagonal of the matrix.
	 *
	 * @return The product of the main diagonal of
	 * the matrix
	 * @throws Exception If matrix is not a square
	 */
	public int multiplyDiameter() throws Exception {
		if (validateSquaredMatrix()) {
			throw new Exception("Matrix is not a square!");
		}

		int result = 1;

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (i == j) {
					result *= matrix[i][j];
				}
			}
		}

		return result;
	}

	/**
	 * Checks if the matrix is square.
	 *
	 * @return {@code true} if it is and {@code false}
	 * if it isn't
	 */
	public boolean validateSquaredMatrix() {
		return n != m;
	}

	/**
	 * Calculates the <b>determinant</b> of the matrix.
	 * <p><b>Determinant</b> - a numerical characteristic
	 * corresponding to each matrix.</p>
	 *
	 * @return The determinant of the matrix
	 * @throws Exception If the matrix is not a square
	 */
	public int determinant() throws Exception {
		if (validateSquaredMatrix()) {
			throw new Exception("Matrix is not a square!");
		}

		final Matrix temp = new Matrix(matrix);
		temp.makeTriangular();
		return temp.multiplyDiameter() * determinantSign;
	}
}