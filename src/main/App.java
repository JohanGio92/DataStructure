package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tree.BTree;

public class App {
	
	public static void main(String[] args) {
		//BNode root = new BNode(4, true);
		//root.addKey(0, 0);
		//root.addKey(1, 1);
		//root.addKey(2, 2);
		//root.addKey(3, 3);
		//root.addKey(4, 4);
		//root.addKey(5, 5);
		//root.addKey(6, 6);
		//inOrder(root);
		
		BTree<Integer> btree = new BTree<>(2);
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			btree.add(random.nextInt(1000));
		}
		
		//for (int i = 0; i <= 1000; i++) {
		//	btree.add(i);
		//}
		System.out.println("hello");
		//btree.hasSameSize();
		btree.traverse();
	}

}
