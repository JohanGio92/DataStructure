package main;

import heap.MaxHeap;

public class App {

	public static void main(String[] args) {
		
		MaxHeap maxHeap = new MaxHeap();
		maxHeap.add(0);
		maxHeap.add(1);
		maxHeap.add(2);
		maxHeap.add(3);
		maxHeap.add(4);
		maxHeap.add(5);
		maxHeap.add(6);
		
		maxHeap.display();
		maxHeap.print();
		maxHeap.removeRoot();
		maxHeap.update(2, 10);
		maxHeap.update(2, -10);
		maxHeap.remove(3);
		System.out.println("=========================");
		maxHeap.print();
		
		while (!maxHeap.isEmpty()) {
			System.out.println(maxHeap.removeRoot());
		}
		
		MaxHeap otherHeap = new MaxHeap();
		otherHeap.add(10);
		otherHeap.add(20);
		otherHeap.removeRoot();
		otherHeap.display();
		System.out.println("=========================");
		int[] newArray = {6, 2, 5, 0, 4, 1 ,3};
		MaxHeap newHeap = new MaxHeap(newArray);
		
		newHeap.add(20);
		newHeap.add(70);
		newHeap.add(10);
		newHeap.display();
		newHeap.print();
	}

}
