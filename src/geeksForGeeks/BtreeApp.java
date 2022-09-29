package geeksForGeeks;

import java.util.Random;

public class BtreeApp {
	
	public static void testTree() {
		BTree tree = new BTree(3);
		tree.insert(1);
		tree.insert(3);
		tree.insert(7);
		tree.insert(10);
		tree.insert(11);
		tree.insert(13);
		tree.insert(14);
		tree.insert(15);
		tree.insert(18);
		tree.insert(16);
		tree.insert(19);
		tree.insert(24);
		tree.insert(25);
		tree.insert(26);
		tree.insert(21);
		tree.insert(4);
		tree.insert(5);
		tree.insert(20);
		tree.insert(22);
		tree.insert(2);
		tree.insert(17);
		tree.insert(12);
		tree.insert(6);

		System.out.println("Traversal of tree constructed is");
		tree.traverse();
		System.out.println();

		tree.remove(6);
		System.out.println("Traversal of tree after removing 6");
		tree.traverse();
		System.out.println();

		tree.remove(13);
		System.out.println("Traversal of tree after removing 13");
		tree.traverse();
		System.out.println();

		tree.remove(7);
		System.out.println("Traversal of tree after removing 7");
		tree.traverse();
		System.out.println();

		tree.remove(4);
		System.out.println("Traversal of tree after removing 4");
		tree.traverse();
		System.out.println();

		tree.remove(2);
		System.out.println("Traversal of tree after removing 2");
		tree.traverse();
		System.out.println();

		tree.remove(16);
		System.out.println("Traversal of tree after removing 16");
		tree.traverse();
		System.out.println();
	}

	public static void main(String[] args) {
		//testTree();
		Random random = new Random();
		BTree tree = new BTree(3);
		
		for (int i = 0; i < 100; i++) {
			tree.insert(random.nextInt(1000));
		}
		tree.traverse();
		System.out.println("======================");
		for (int i = 0; i < 50; i++) {
			tree.remove(random.nextInt(1000));
		}
		
		tree.traverse();
	}

}
