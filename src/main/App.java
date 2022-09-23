package main;

import tree.BinarySearchTree;
import tree.Node;

public class App {

	public static void main(String[] args) {
		System.out.println("hello world");
		
		Node<Integer> node = new Node<Integer>(5);
		Node<Integer> other = new Node<Integer>(5);
		System.out.println(node.equals(other));
		other.setData(6);
		System.out.println(node.equals(other));
		
		Node<Integer> copiedNode = other.copy();
		System.out.println(copiedNode.equals(other));
		
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.add(10);
		binarySearchTree.add(5);
		binarySearchTree.add(11);
		binarySearchTree.add(20);
		binarySearchTree.remove(5);
		binarySearchTree.inOrder();
	
		System.out.println("======================");
		System.out.println(binarySearchTree.find(21));
		System.out.println(binarySearchTree.getMin());
		System.out.println(binarySearchTree.getMax());
		
	}

}
