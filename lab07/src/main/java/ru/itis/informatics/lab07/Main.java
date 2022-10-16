package ru.itis.informatics.lab07;

public class Main {
	public static void main(String[] args) {
		Point a = new Point(1, 2);
		Point b = new Point(4, 5);
		Vector vector = new Vector(a, b);

		System.out.println("Coordinates of vector's middle point: " + vector.calculateMiddle());
		System.out.println("Vector before transfer: " + vector);

		Point c = new Point(8, 6);
		Point d = new Point(11, 9);
		Vector anotherVector = new Vector(c, d);

		vector.parallelTransfer(anotherVector);

		System.out.println("Vector after transfer: " + vector);
	}
}