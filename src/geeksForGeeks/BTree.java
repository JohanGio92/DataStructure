package geeksForGeeks;


public class BTree {
	BTreeNode root;
	int minimunDegree;
	
	BTree(int degree) {
		root = null;
		minimunDegree = degree;
	}

	public void traverse() {
		if (root != null) root.traverse();
	}

	public BTreeNode search(int key) {
		return (root == null) ? null : root.search(key);
	}

	void insert(int key) {
		if (root == null) {
			root = new BTreeNode(minimunDegree, true);
			root.keys[0] = key;
			root.keySize = 1;
		}
		else {
			if (root.keySize == 2*minimunDegree-1) {
				BTreeNode newParent = new BTreeNode(minimunDegree, false);
				newParent.children[0] = root;
				newParent.splitChild(0, root);
				int i = 0;
				if (newParent.keys[0] < key)
					i++;
				newParent.children[i].insert(key);
				root = newParent;
			}
			else
				root.insert(key);
		}
	}

	public void remove(int key) {
		if (root == null) {
			System.out.println("Is Empty");
			return;
		}
		root.remove(key);
		if (root.keySize == 0) {
			if (root.leaf)
				root = null;
			else
				root = root.children[0];
		}
		return;
	}
}