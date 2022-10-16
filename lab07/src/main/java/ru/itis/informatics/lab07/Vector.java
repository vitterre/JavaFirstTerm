package ru.itis.informatics.lab07;

public class Vector {
	private Point start;
	private Point end;

	public Point getStart() {
		return start;
	}

	public Point getEnd() {
		return end;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public Vector(Point start, Point end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Vector{" +
						"start=" + start +
						", end=" + end +
						'}';
	}

	public double calculateLength() {
		return start.calculateDistance(end);
	}

	public boolean parallelTransfer(Vector v) {
		if (Math.abs(calculateLength() - v.calculateLength()) >= 0.0000001) {
			return false;
		}

		start.setX(v.getStart().getX());
		start.setY(v.getStart().getY());

		end.setX(v.getEnd().getX());
		end.setY(v.getEnd().getY());

		return true;
	}

	public Point calculateMiddle() {
		return new Point(
						(start.getX() + end.getX()) / 2,
						(start.getY() + end.getY()) / 2
		);
	}
}