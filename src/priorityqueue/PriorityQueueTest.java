package priorityqueue;

import priorityqueue.array.PriorityQueueArray;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueueArray queuePriority = new PriorityQueueArray();
		
		queuePriority.enqueue(1, 1);
		queuePriority.enqueue(2, 4);
		queuePriority.enqueue(3, 5);
		queuePriority.enqueue(6, 3);
		queuePriority.enqueue(6, 2);
		queuePriority.enqueue(6, 5);
		queuePriority.enqueue(6, 4);
		
		while (!queuePriority.isEmpty()) {
			System.out.println(queuePriority.dequeue());
		}
	}

}
