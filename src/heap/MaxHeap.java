package heap;

public class MaxHeap {
	
	private static final int FULL = 1000;
	private static final int EMPTY = 0;
	private static final int FIRST = EMPTY;
	private static final int BINARY = 2;
	private int[] vector;
	private int last;
	
	public MaxHeap() {
		vector = new int[FULL];
		last = 0;
	}
	
	public MaxHeap(int[] vector) {
		assert vector.length == FULL;
		copy(vector);
		toHeap();
	}
	
	private void toHeap() {
		for (int parent = parent(last); parent >= 0; parent -= BINARY) {
			goDown(parent);
		}
	}
	
	public void copy(int[] vector) {
		this.vector = new int[FULL];
		last = vector.length;
		for (int i = 0; i < vector.length; i++) {
			this.vector[i] = vector[i];
		}
	}
	
	public int parent(int index) {
		return (int) Math.floor((index - 1)/BINARY);
	}
	
	public int leftChild(int index) {
		return (index * BINARY ) + 1;
	}

	public int rightChild(int index) {
		return (index * BINARY ) + 2;
	}
	
	public void goUp(int child) {
		if(child != FIRST) {
			int parent = parent(child);
			if(vector[child] > vector[parent]) {
				swap(child, parent);
				goUp(parent);
			}
		}
	}
	
	public void goDown(int parent) {

		int left = leftChild(parent);
		int right = rightChild(parent);
		int largest = parent;
		
		if(left < last && vector[left] > vector[largest]) {
			largest = left;
		}
		
		if(right < last && vector[right] > vector[largest]) {
			largest = right;
		}
		
		if(largest != parent) {
			swap(largest, parent);
			goDown(largest);
		}
	}
	
	public void claimUp() {
		int child = last;
		int parent = parent(child);

		while (child != FIRST && vector[parent] < vector[child]) {
	       swap(child, parent);
	       child = parent(child);
	    }
	}
	
	private void swap(int from, int to) {
		int temporal = vector[from];
		vector[from] = vector[to];
		vector[to] = temporal;
	}
	
	public void add(int data) {
		vector[last] = data;
		goUp(last);
		last++;
	}
	
	public int removeRoot() {
		assert !isEmpty();
		int root = vector[FIRST];
		swap(FIRST , --last);
		goDown(FIRST);
		return root;
	}
	
	public int remove(int index) {
		assert !isEmpty();
		vector[index] = Integer.MAX_VALUE;
		goUp(index);
		return removeRoot();
	}
	
	public void update(int index, int data) {
		vector[index] = data;
		goUp(index);
		goDown(index);
	}
	
	public int Max() {
		return vector[FIRST];
	}
	
	public void print() {
        for (int index = 0; index < last/BINARY; index++) {
            System.out.print("Parent Node : " + vector[index]);
            if (leftChild(index) < last)
                System.out.print(" Left Child Node: " + vector[leftChild(index)]);
            if (rightChild(index) < last)
                System.out.print(" Right Child Node: " + vector[rightChild(index)]);
            System.out.println();
        }
    }
	
	public void display() {
		for (int i = 0; i < last; i++) {
			System.out.println(vector[i]);
		}
	}
	
	public boolean isEmpty() {
		return last == EMPTY;
	}
}
