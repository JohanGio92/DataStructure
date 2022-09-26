package main;

import java.util.Random;

import tree.AVLTree;

public class App {

	public static void main(String[] args) {
		
		Random random = new Random();
		AVLTree<Integer> tree = new AVLTree<>();
		tree.add(5);
		tree.add(50);
		tree.add(15);
		tree.add(10);
		tree.add(10);
		tree.add(10);
		
		for (int i = 0; i < 200; i++) {
			tree.add(random.nextInt(100));
		}
		
		System.out.println(tree.size());
		for (int i = 0; i < 500; i++) {
			int randomNumber = random.nextInt(100);
			if (tree.has(randomNumber)) {
				tree.remove(randomNumber);
			}
		}
		System.out.println("level");
		tree.levelOrder();
		System.out.println("=================");
		System.out.println("size: " + tree.size());
		System.out.println("=================");
		System.out.println("inOrder");
		tree.inOrder();
		System.out.println("=================");
		System.out.println("preOrder");
		tree.preOrder();
		System.out.println(tree.has(5));
	}

}
