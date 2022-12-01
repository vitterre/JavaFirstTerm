package ru.itis.informatics.lab11;

public final class Node {

	/* ----- Fields ----- */

	public int data;
	public Node left;
	public Node right;


	/* ----- Constructors ----- */

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}
