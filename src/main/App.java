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
		
		for (int i = 0; i < 1000; i++) {
			tree.add(random.nextInt(1000));
		}
		tree.inOrder();
		System.out.println("=================");
		tree.preOrder();
	}

}
