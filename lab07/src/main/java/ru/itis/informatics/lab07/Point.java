package ru.itis.informatics.lab07;

/**
 * Описать отрезок (x1, y1), (x2, y2)
 * 1) Метод параллельного переноса отрезка
 *    в направлении вектора v(x, y)
 * 2) Метод нахождения точки середины отрезка
 * 3) Написать модульные тесты (по приколу)
 */
public class Point {
	double x;
	double y;

	public double getDistance(Point p) {
		return Math.sqrt(
						(x - p.x) * (x - p.x) + (y - p.y) * (y - p.y)
		);
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
