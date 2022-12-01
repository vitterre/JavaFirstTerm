package ru.itis.informatics.lab10;

public final class LinkedList {

	/* ----- Fields ----- */

	public Node headNode;
	public int size;


	/* ----- Constructors ----- */

	public LinkedList() {
		this.headNode = null;
		this.size = 0;
	}


	/* ----- Public methods ----- */

	public void add(final int data) {
		Node newNode = new Node(data);

		if (this.headNode == null) {
			this.headNode = newNode;

		} else {
			Node currentNode = this.headNode;

			while (currentNode.nextNode != null) {
				currentNode = currentNode.nextNode;
			}

			currentNode.nextNode = newNode;
		}

		this.size++;

	}

	public void remove(final int data) {
		Node currentNode = this.headNode;
		Node previousNode = null;

		while (currentNode.nextNode != null) {
			if (currentNode.value == data) {
				if (currentNode.equals(this.headNode)) {
					this.headNode = currentNode.nextNode;
				} else {
					previousNode.nextNode = currentNode.nextNode;
				}
			}

			previousNode = currentNode;
			currentNode = currentNode.nextNode;
		}

		this.size--;
	}

	public void sort() {
		Node currentNode = this.headNode, index = null;

		int temp;

		while (currentNode != null) {
			index = currentNode.nextNode;
			while (index != null) {
				if (currentNode.value > index.value) {
					temp = currentNode.value;
					currentNode.value = index.value;
					index.value = temp;
				}
				index = index.nextNode;
			}
			currentNode = currentNode.nextNode;
		}
	}

	public int findElement(final int data) {
		Node currentNode = this.headNode;
		int index = -1;

		while (currentNode != null) {
			index++;

			if (currentNode.value == data) {
				break;
			}

			currentNode = currentNode.nextNode;
		}

		return index;
	}

	@Override
	public String toString() {
		if (this.headNode == null) {
			return "{}";
		}

		StringBuilder output = new StringBuilder();

		Node currentNode = this.headNode;
		output.append("{" + currentNode.value + ", ");
		currentNode = currentNode.nextNode;

		while (currentNode != null) {
			output.append(currentNode.value + (currentNode.nextNode == null ? "}" : ", "));
			currentNode = currentNode.nextNode;
		}

		return new String(output);
	}

}
