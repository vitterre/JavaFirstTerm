package ru.itis.informatics.lab11;

public class Main {
	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.build(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
		bst.printTree();
	}
}