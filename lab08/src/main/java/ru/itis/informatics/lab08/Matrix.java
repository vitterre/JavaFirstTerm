package ru.itis.informatics.lab08;

public class Matrix {
	private final double a11;
	private double a12;
	private double a21;
	private final double a22;

	public Matrix(final double a11, final double a12, final double a21, final double a22) {
		this.a11 = a11;
		this.a12 = a12;
		this.a21 = a21;
		this.a22 = a22;
	}

	public Matrix() {
		this.a11 = 0;
		this.a12 = 0;
		this.a21 = 0;
		this.a22 = 0;
	}

	public double getA11() {
		return a11;
	}

	public double getA12() {
		return a12;
	}

	public double getA21() {
		return a21;
	}

	public double getA22() {
		return a22;
	}

	public double[][] getMatrix() {
		return new double[][]{{a11, a12}, {a21, a22}};
	}

	Matrix plus(final Matrix otherMatrix) {
		if (otherMatrix == null) {
			return null;
		}

		return new Matrix(
						a11 + otherMatrix.a11,
						a12 + otherMatrix.a12,
						a21 + otherMatrix.a21,
						a22 + otherMatrix.a22
		);
	}

	Matrix minus(final Matrix otherMatrix) {
		return plus(otherMatrix.multiply(-1));
	}

	Matrix multiply(final double number) {
		return new Matrix(
						number * a11,
						number * a12,
						number * a21,
						number * a22
		);
	}

	Matrix multiply(final Matrix otherMatrix) {
		return new Matrix(
						a11 * otherMatrix.getA11() + a12 * otherMatrix.getA12(),
						a11 * otherMatrix.getA12() + a12 * otherMatrix.getA22(),
						a21 * otherMatrix.getA11() + a22 * otherMatrix.getA12(),
						a21 * otherMatrix.getA12() + a22 * otherMatrix.getA22()
		);
	}

	public void transform() {
		final double _a12 = a12;

		a12 = a21;
		a21 = _a12;
	}

	public double determinant() {
		return a11 * a22 - a12 * a21;
	}

	@Override
	public String toString() {
		return "|| " + a11 + " " + a12 + " ||\n" +
						"|| " + a21 + " " + a22 + " ||\n";
	}


}
