package ru.itis.informatics.lab10;

public final class Node {

	/* ----- Fields ----- */

	public int value;
	public Node nextNode;

	/* ----- Constructors ----- */

	public Node(final int value) {
		this.value = value;
		this.nextNode = null;
	}

	@Override
	public String toString() {
		if (this.nextNode != null) {
			return "{" +
							value +
							", ->" + nextNode +
							'}';
		}
		return "{" +
						value +
						'}';
	}
}
