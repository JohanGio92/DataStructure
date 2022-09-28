package simpleBTree;

public class Btree {

	private BNode root;
	private int minimunDegree;
	private int maximunDegree;
	private int maximunKeys;
	
	public Btree(int degree) {
		this.minimunDegree = degree;
		this.maximunDegree = 2 * minimunDegree;
		this.maximunKeys = maximunDegree - 1;
		root = null;
	}
	
	public void traverse() {
		assert root != null;
		root.traverse();
	}
	
	private BNode hasNode(int key) {
		return root != null ? root.hasNode(key) : null;
	}
	
	public void add(int key) {
		if(root == null) {
			root = new BNode(minimunDegree, true);
			root.addKey(0, key);
			root.setKeySize(1);
		}
		else {
			if(iskeysFull()) {
				BNode newParent = new BNode(minimunDegree, false);
				newParent.setChild(0, root);
				newParent.splitChild(0, root);
				int index = 0;
				if(newParent.getKey(0) < key) {
					index++;
				}
				newParent.getChild(index).addNotFull(key);
				root = newParent;
			}
			else {
				root.addNotFull(key);
			}
		}
	}

	private boolean iskeysFull() {
		return root.getKeySize() == maximunKeys;
	}

}
