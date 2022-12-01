package ru.itis.informatics.lab11;

public class BinarySearchTree {

	/* ----- Fields ----- */

	public Node headNode;


	/* ----- Constructors ----- */

	public BinarySearchTree() {
		this.headNode = null;
	}


	/* ----- Public methods ----- */

	public void add(int newData) {
		this.headNode = add(headNode, newData);
	}

	public Node add(Node node, int newData) {
		if (node == null) {
			node = new Node(newData);
			return node;
		}

		if (node.data >= newData) {
			node.left = add(node.left, newData);
		} else {
			node.right = add(node.right, newData);
		}
		return node;
	}

	public void remove(int data) {
		removeNode(this.headNode, new Node(data));
	}

	public int findMinData(Node node) {
		if (node.left != null) {
			return findMinData(node.left);
		}

		return node.data;
	}

	public int findMaximum() {
		if (headNode == null) {
			return -1;
		}

		Node current = this.headNode;

		while (current.right != null) {
			current = current.right;
		}

		return (current.data);
	}

	public int findMinimum() {
		if (headNode == null) {
			return -1;
		}

		Node current = this.headNode;

		while (current.left != null) {
			current = current.left;
		}

		return (current.data);
	}

	public boolean search(int data) {
		return search(this.headNode, data);
	}

	public int findMaxData(Node node) {
		if (node.right != null) {
			return findMaxData(node.right);
		}

		return node.data;
	}

	public void build(final int[] data) {
		this.headNode = build(data, 0);
	}

	public void printTree() {
		printTree(headNode);
		System.out.println();
	}

	public void printTree(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		printTree(node.left);
		printTree(node.right);

	}


	/* ----- Private methods ----- */

	private Node removeNode(Node node, Node toRemove) {
		if (node == null) {
			return null;
		}
		if (toRemove.data < node.data) {
			node.left = removeNode(node.left, toRemove);
		} else if (toRemove.data > node.data) {
			node.right = removeNode(node.right, toRemove);
		} else {
			if (node.left != null && node.right != null) {
				int lmax = findMaxData(node.left);
				node.data = lmax;
				node.left = removeNode(node.left, new Node(lmax));
				return node;
			}
			if (node.left != null) {
				return node.left;
			}
			if (node.right != null) {
				return node.right;
			}
			return null;
		}
		return node;
	}

	private boolean search(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			return true;
		}
		if (node.data > data) {
			return search(node.left, data);
		}
		return search(node.right, data);
	}

	private Node build(final int[] data, int i) {
		Node node = null;

		if (i < data.length) {
			node = new Node(data[i]);
			node.left = build(data, 2 * i + 1);
			node.right = build(data, 2 * i + 2);
		}

		return node;
	}

}