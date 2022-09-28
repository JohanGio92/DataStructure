package otherSimpleTree;

import java.util.Random;

//Inserting a key on a B-tree in Java 

public class BTree {

	private int minDegree;

	// Node Creation
	public class Node {
		int keySize;
		int keys[] = new int[2 * minDegree - 1];
		Node child[] = new Node[2 * minDegree];
		boolean leaf = true;

		public int Find(int key) {
			for (int index = 0; index < this.keySize; index++) {
				if (this.keys[index] == key) {
					return index;
				}
			}
			return -1;
		};
	}

	public BTree(int degree) {
		minDegree = degree;
		root = new Node();
		root.keySize = 0;
		root.leaf = true;
	}

	private Node root;

	// split
	private void split(Node parent, int index, Node leftChild) {
		Node rightChild = copyRightHalf(leftChild);
		leftChild.keySize = halfPosition();
		for (int j = parent.keySize; j >= index + 1; j--) {
			parent.child[j + 1] = parent.child[j];
		}
		parent.child[index + 1] = rightChild;

		for (int j = parent.keySize - 1; j >= index; j--) {
			parent.keys[j + 1] = parent.keys[j];
		}
		parent.keys[index] = leftChild.keys[halfPosition()];
		parent.keySize = parent.keySize + 1;
	}

	private int halfPosition() {
		return minDegree - 1;
	}

	private Node copyRightHalf(Node leftChild) {
		Node rightChild = new Node();
		rightChild.leaf = leftChild.leaf;
		rightChild.keySize = halfPosition();
		for (int j = 0; j < halfPosition(); j++) {
			rightChild.keys[j] = leftChild.keys[j + minDegree];
		}
		if (!leftChild.leaf) {
			for (int j = 0; j < minDegree; j++) {
				rightChild.child[j] = leftChild.child[j + minDegree];
			}
		}
		return rightChild;
	}

	// insert key
	public void insert(final int key) {
		Node current = root;
		if (current.keySize == 2 * minDegree - 1) {
			Node newParent = new Node();
			root = newParent;
			newParent.leaf = false;
			newParent.keySize = 0;
			newParent.child[0] = current;
			split(newParent, 0, current);
			_insert(newParent, key);
		} else {
			_insert(current, key);
		}
	}

	// insert node
	final private void _insert(Node parent, int key) {

		if (parent.leaf) {
			int i = 0;
			for (i = parent.keySize - 1; i >= 0 && key < parent.keys[i]; i--) {
				parent.keys[i + 1] = parent.keys[i];
			}
			parent.keys[i + 1] = key;
			parent.keySize = parent.keySize + 1;
		} else {
			int i = 0;
			for (i = parent.keySize - 1; i >= 0 && key < parent.keys[i]; i--) {
			}
			;
			i++;
			Node tmp = parent.child[i];
			if (tmp.keySize == 2 * minDegree - 1) {
				split(parent, i, tmp);
				if (key > parent.keys[i]) {
					i++;
				}
			}
			_insert(parent.child[i], key);
		}

	}

	public void display() {
		display(root);
	}

	// Display the tree
	private void display(Node root) {
		assert (root == null);
		for (int i = 0; i < root.keySize; i++) {
			System.out.print(root.keys[i] + "!");
		}
		System.out.println();
		if (!root.leaf) {
			for (int i = 0; i < root.keySize + 1; i++) {
				display(root.child[i]);
			}
		}
	}
	
	public void print() {
		this.print(root);
	}
	
	// Display the tree
	private void print(Node root) {
		if(root != null) {
			int i;
			for (i = 0; i < root.keySize; i++) {
				print(root.child[i]);
				System.out.print(root.keys[i] + " ");
			}
			if (!root.leaf) {
				print(root.child[i]);
			}
		}
	}

	public static void main(String[] args) {
		BTree b = new BTree(3);
		b.insert(8);
		b.insert(9);
		b.insert(10);
		b.insert(11);
		b.insert(15);
		b.insert(20);
		b.insert(17);
		Random random = new Random();
		for (int i = 0; i < 1000; i++) {
			b.insert(random.nextInt(1000));
			
		}
		b.display();
		b.print();
	}
}