package ru.itis.informatics.lab13;

public final class StackImplList implements IStack {

	/* ----- Fields ----- */

	private Node headNode;


	/* ----- Overrides ----- */

	@Override
	public Object pop() {
		Node tmp = this.headNode;

		if (this.headNode != null) {
			this.headNode = this.headNode.prev;
		}

		return tmp;
	}

	@Override
	public void push(Object o) {
		Node element = new Node(o);
		element.prev = this.headNode;

		this.headNode = element;
	}

}
