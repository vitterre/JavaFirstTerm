package ru.itis.informatics.lab10;

public class Main {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();

		linkedList.add(30);
		linkedList.add(50);
		linkedList.add(40);

		linkedList.sort();

		System.out.println(linkedList);

		System.out.println(linkedList.findElement(40));
	}
}