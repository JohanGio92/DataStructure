package disjoint;

public class DisjointSet {

	private int[] treeHeights;
	private int[] parent;
	private int size;
	
	public DisjointSet(int size) {
		this.size = size;
		this.parent = new int[size];
		this.treeHeights = new int[size];
		this.makeSet();
	}
	
	public void makeSet() {
		for (int i = 0; i < size; i++) {
			this.parent[i] = i;
		}
	}
	
	public int findRoot(int x) {
        if (parent[x] != x) {
            parent[x] = findRoot(parent[x]);
        }
        return parent[x];
    }
	
	public void union(int x, int y) {
        int xRoot = findRoot(x);
        int yRoot = findRoot(y);

        if (!isEqualSet(xRoot, yRoot))
        	linkTreeByHeight(xRoot, yRoot);
    }
	
	private void linkTreeByHeight(int xRoot, int yRoot) {
        if (treeHeights[xRoot] < treeHeights[yRoot])
            parent[xRoot] = yRoot;
        else if (treeHeights[yRoot] < treeHeights[xRoot])
            parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            treeHeights[xRoot] = treeHeights[xRoot] + 1;
        }
	}
	
	public boolean isEqualSet(int x, int y) {
		return findRoot(x) == findRoot(y);
	}
}
