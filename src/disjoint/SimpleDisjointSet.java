package disjoint;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class SimpleDisjointSet {
	
	Vector<Integer> vector;
	public static final int MAX_SIZE = 10;
	public static final int ROOT = -1;
	
	public SimpleDisjointSet() {
		vector = new Vector<>();
	}
	
	public void fill() {
		for (int i = 0; i < MAX_SIZE; i++) {
			vector.add(ROOT);
		}
	}
	
	public int findRoot(int parent) {
		if(vector.get(parent) ==  ROOT) {
			return parent;
		}
		return findRoot(vector.get(parent));
	}
	
	public void union(int x, int y) {
		x = findRoot(x);
		y = findRoot(y);
		vector.set(x, y);
	}
	
	public boolean isCyclic(Vector<HashMap<Integer, Integer>> edgeList) {
		
		for (HashMap<Integer, Integer> edge : edgeList) {
			for (Map.Entry<Integer, Integer> entry : edge.entrySet()) {
				Integer key = entry.getKey();
				Integer val = entry.getValue();
				int rootA = findRoot(key);
				int rootB = findRoot(val);
				if(rootA == rootB) {
					return true;
				}
				union(rootA, rootB);
			}
		}
		return false;
	}
}
