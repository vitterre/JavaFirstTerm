package ru.itis.informatics.lab13;

public final class QueueNodes<T> implements IQueue {

	private class Node {

		/* ----- Fields ----- */

		public Object object;
		public Node next;


		/* ----- Constructors ----- */

		public Node(final Object o) {
			this.object = o;
		}

		@Override
		public String toString() {
			return "Node{" +
							"object=" + object +
							", next=" + next +
							'}';
		}
	}


	/* ----- Fields ----- */

	private Node headNode = null;
	public int size = 0;


	/* ----- Override methods ----- */

	@Override
	public void add(Object element) {
		Node newNode = new Node((T)element);

		if (this.headNode == null) {
			this.headNode = newNode;
		} else {
			Node currentNode = this.headNode;

			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}

			currentNode.next = newNode;
		}

		this.size++;
	}

	@Override
	public Object remove() {
		final Node removable = this.headNode;

		if (this.headNode.next != null) {
			this.headNode = this.headNode.next;
		}

		this.size--;

		return removable;
	}

	@Override
	public Object peek() {
		return (T)this.headNode;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		return "QueueNodes{" +
						"headNode=" + headNode +
						", size=" + size +
						'}';
	}
}
