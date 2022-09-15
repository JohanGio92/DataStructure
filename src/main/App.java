package main;

import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import queue.ArrayQueue;

public class App {

	public static void main(String[] args) {
		
		ArrayQueue arrayQueue = new ArrayQueue();
		
		arrayQueue.enqueue(0);
		arrayQueue.enqueue(1);
		arrayQueue.enqueue(2);
		arrayQueue.enqueue(3);
		arrayQueue.enqueue(4);
		arrayQueue.enqueue(5);
		
		while (!arrayQueue.isEmpty()) {
			System.out.println(arrayQueue.dequeue());
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(5);
		queue.add(6);
		queue.add(7);
		queue.add(8);
		queue.add(9);
		
		
		while (!queue.isEmpty()) {
			System.out.println(queue.remove());
		}
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		deque.addFirst(21);
		deque.addFirst(22);
		deque.addFirst(23);
		deque.addFirst(24);
		
		//while (!deque.isEmpty()) {
		//	System.out.println(deque.removeLast());
		//}
		
		Iterator<Integer> iterator = deque.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}

}
