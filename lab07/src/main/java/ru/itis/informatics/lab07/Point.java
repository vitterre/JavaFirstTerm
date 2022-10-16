package ru.itis.informatics.lab07;

public class Point {
	private double x;
	private double y;

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double calculateDistance(Point p) {
		return Math.sqrt(
						(x - p.x) * (x - p.x) + (y - p.y) * (y - p.y)
		);
	}

	@Override
	public String toString() {
		return "Point{" +
						"x=" + x +
						", y=" + y +
						'}';
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}