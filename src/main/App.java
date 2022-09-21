package main;

import tree.BinaryTree;

public class App {

	public static void main(String[] args) {
		
		BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(10);

		binaryTree.appendLeft(5);
		binaryTree.appendRight(20);
		binaryTree.preOrder();
		System.out.println("===================");
		binaryTree.inOrder();
		System.out.println("===================");
		binaryTree.levelOrder();
		System.out.println("===================");
		binaryTree.add(14);
		binaryTree.add(60);
		binaryTree.add(30);
		binaryTree.add(50);
		binaryTree.remove(5);
		binaryTree.levelOrder();
		System.out.println("===================");
		System.out.println(binaryTree.getLast());
		
		
	}

}
