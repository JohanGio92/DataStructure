package geeksForGeeks;

public class BTreeNode {
	int[] keys; // An array of keys
	int minimunDegree;	 // Minimum degree (defines the range for number of keys)
	int maximunDegree;
	int maximunKeys;
	BTreeNode[] children; // An array of child pointers
	int keySize;	 // Current number of keys
	boolean leaf; // Is true when node is leaf. Otherwise false

	public BTreeNode(int minimunDegree, boolean leaf){
		this.minimunDegree = minimunDegree;
		this.maximunDegree = 2*minimunDegree;
		this.maximunKeys = maximunDegree - 1;
		this.leaf = leaf;
		keys = new int[maximunKeys];
		children = new BTreeNode [maximunDegree];
		keySize = 0;
	}
	// A function to traverse all nodes in a subtree rooted with this node
	public void traverse() {
		int i;
		for (i = 0; i < keySize; i++) {
			if (!leaf)
				children[i].traverse();
			System.out.println(" " + keys[i]);
		}
		if (!leaf)
			children[i].traverse();
	}
	
	public BTreeNode search(int key){
		int i = 0;
		while (i < keySize && key > keys[i])
			i++;
		if (keys[i] == key)
			return this;
		if (leaf == true)
			return null;
		return children[i].search(key);
	}

	// A function that returns the index of the first key that is greater
	// or equal to k
	public int findKey(int key) {
		int index = 0;
		while (index < keySize && keys[index] < key)
			++index;
		return index;
	}

	void insert(int key) {
		int i = keySize-1;
		if (leaf == true) {
			while (i >= 0 && keys[i] > key) {
				keys[i+1] = keys[i];
				i--;
			}
			keys[i+1] = key;
			keySize = keySize+1;
		}
		else {
			while (i >= 0 && keys[i] > key)
				i--;
			if (children[i+1].keySize == maximunKeys()) {
				splitChild(i+1, children[i+1]);
				if (keys[i+1] < key)
					i++;
			}
			children[i+1].insert(key);
		}
	}
	private int maximunKeys() {
		return 2*minimunDegree-1;
	}

	void splitChild(int index, BTreeNode fullLeftChild) {
		BTreeNode rightChild = copyRighHalf(fullLeftChild);
		fullLeftChild.keySize = minimunDegree - 1;
		for (int j = keySize; j >= index+1; j--)
			children[j+1] = children[j];
		children[index+1] = rightChild;
		for (int j = keySize-1; j >= index; j--)
			keys[j+1] = keys[j];
		keys[index] = fullLeftChild.keys[minimunDegree-1];
		keySize = keySize + 1;
	}

	private BTreeNode copyRighHalf(BTreeNode fullLeftChild) {
		BTreeNode rightChild = new BTreeNode(fullLeftChild.minimunDegree, fullLeftChild.leaf);
		rightChild.keySize = minimunDegree - 1;
		for (int j = 0; j < minimunDegree - 1; j++)
			rightChild.keys[j] = fullLeftChild.keys[ j + minimunDegree];
		if (fullLeftChild.leaf == false) {
			for (int j = 0; j < minimunDegree; j++)
				rightChild.children[j] = fullLeftChild.children[j+minimunDegree];
		}
		return rightChild;
	}

	void remove(int key) {
		int index = findKey(key);
		if (index < keySize && keys[index] == key) {
			if (leaf)
				removeLeaf(index);
			else
				removeInternal(index);
		} else {
			if (leaf) {
				System.out.println("The key" + key + " is does not exist in the tree");
				return;
			}
			// The key to be removed is present in the sub-tree rooted with this node
			// The flag indicates whether the key is present in the sub-tree rooted
			// with the last child of this node
			boolean flag = (index == keySize)
					? true 
					: false;
			if (children[index].keySize < minimunDegree)
				borrow(index);
			// If the last child has been merged, it must have merged with the previous
			// child and so we recurse on the (idx-1)th child. Else, we recurse on the
			// (idx)th child which now has atleast t keys
			if (flag && index > keySize)
				children[index-1].remove(key);
			else
					children[index].remove(key);
		}
		return;

	}

	void removeLeaf(int index) {
		for (int i=index+1; i<keySize; ++i)
			keys[i-1] = keys[i];
		keySize--;
		return;
	}

	void removeInternal(int index) {
		int key = keys[index];
		if (children[index].keySize >= minimunDegree) {
			int maxKey = getMaxKey(index);
			keys[index] = maxKey;
			children[index].remove(maxKey);
		}
		else if (children[index+1].keySize >= minimunDegree) {
			int minKey = getMinKey(index);
			keys[index] = minKey;
			children[index+1].remove(minKey);
		}
		else {
			merge(index);
			children[index].remove(key);
		}
		return;
	}

	int getMaxKey(int index) {
		BTreeNode iterator=children[index];
		while (!iterator.leaf)
			iterator = iterator.children[iterator.keySize];
			return iterator.keys[iterator.keySize-1];
	}

	int getMinKey(int index) {
		BTreeNode iterator = children[index+1];
		while (!iterator.leaf)
			iterator = iterator.children[0];
			return iterator.keys[0];
	}

	void borrow(int index) {
		if (index!=0 && children[index-1].keySize>=minimunDegree)
			borrowMePreviousChild(index);
		else if (index!=keySize && children[index+1].keySize>=minimunDegree)
			borrowMeNextChild(index);
		else {
			if (index != keySize)
				merge(index);
			else
				merge(index-1);
		}
	}

	void borrowMePreviousChild(int idx) {
		BTreeNode child = children[idx];
		BTreeNode sibling = children[idx-1];
		for (int i=child.keySize - 1; i >=0 ; --i)
			child.keys[i+1] = child.keys[i];
		if (!child.leaf) {
			for(int i = child.keySize; i>=0; --i)
				child.children[i+1] = child.children[i];
		}
		child.keys[0] = keys[idx-1];
		if(!child.leaf)
			child.children[0] = sibling.children[sibling.keySize];
		keys[idx-1] = sibling.keys[sibling.keySize-1];
		child.keySize += 1;
		sibling.keySize -= 1;
	}

	void borrowMeNextChild(int idx) {
		BTreeNode child=children[idx];
		BTreeNode sibling=children[idx+1];
		child.keys[child.keySize] = keys[idx];
		if (!child.leaf)
			child.children[(child.keySize)+1] = sibling.children[0];
		keys[idx] = sibling.keys[0];
		for (int i=1; i < sibling.keySize; ++i)
			sibling.keys[i-1] = sibling.keys[i];
		if (!sibling.leaf) {
			for(int i=1; i<=sibling.keySize; ++i)
				sibling.children[i-1] = sibling.children[i];
		}
		child.keySize += 1;
		sibling.keySize -= 1;
	}

	public void merge(int index) {
		BTreeNode childLeft = children[index];
		BTreeNode childRight = children[index+1];
		childLeft.keys[minimunDegree-1] = this.keys[index];
		childLeft.keySize++;
		union(childLeft, childRight);
		deletePair(index);
	}

	private void deletePair(int index) {
		for (int i=index+1; i<keySize; ++i)
			keys[i-1] = keys[i];
		//deleted from the right
		for (int i=index+2; i<=keySize; ++i)
			children[i-1] = children[i];
		keySize--;
	}

	private void union(BTreeNode childLeft, BTreeNode childRight) {
		for (int i=0; i<childRight.keySize; ++i)
			childLeft.keys[i+minimunDegree] = childRight.keys[i];
		if (!childLeft.leaf) {
			for(int i=0; i<=childRight.keySize; ++i)
				childLeft.children[i+minimunDegree] = childRight.children[i];
		}
		childLeft.keySize += childRight.keySize;
	}
}
