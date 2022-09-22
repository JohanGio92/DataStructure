package main;

import link.Iterator;
import link.LinkedList;

public class App {

	public static void main(String[] args) {
		
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(0, 0);
		linkedList.add(1, 1);
		linkedList.add(2);
		linkedList.add(3, 1);
		linkedList.add(4);
		linkedList.remove(1);
		
		LinkedList<Integer> copiedList = linkedList.copy();
		
		System.out.println("=========================");
		while (linkedList.hasNext()) {
			System.out.println(linkedList.next());
		}
		System.out.println("=========================");
		while (copiedList.hasNext()) {
			System.out.println(copiedList.next());
		}
		System.out.println("=========================");
		LinkedList<Integer> list = new LinkedList<>(copiedList);
		
		Iterator<Integer> iterator = list.iterate();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}

}
