package disjoint;

import java.util.HashMap;
import java.util.Map;

public class DisjointTreeSet {
	
	private Map<Integer, Node> map;
	
	public DisjointTreeSet() {
		map = new HashMap<>();
	}
	
	public void makeSet(int data) {
		Node node = new Node(data);
		node.setParent(node);
		map.put(data, node);
	}
	
	public int findSet(int data) {
		return findRoot(map.get(data)).getData();
	}
	
	private Node findRoot(Node node) {
        Node parent = node.getParent();
        if (parent == node) {
            return parent;
        }
        node.setParent(findRoot(node.getParent()));
        return node.getParent();
    }
	
	public boolean union(int data1, int data2) {

        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = findRoot(node1);
        Node parent2 = findRoot(node2);

        if (parent1.getData() == parent2.getData()) {
            return false;
        }

        linkTreesByHeight(parent1, parent2);
        return true;
    }
	
	private void linkTreesByHeight(Node parent1, Node parent2) {
        if (parent1.getHeight() > parent2.getHeight()) {
            parent2.setParent(parent1);
        } else if (parent1.getHeight() < parent2.getHeight()) {
            parent1.setParent(parent2);
        } else {
            parent2.setParent(parent1);
            parent1.increaseHeight();
        }
	}
	
	public boolean isEqualSet(int data1, int data2) {
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);
        return findRoot(node1) == findRoot(node2);
	}
}
