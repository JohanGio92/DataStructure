package tree;

public class BTree<E extends Comparable<E>> {
	
	private int degree;
	private int maximunDegree;
	private int maximunKeys;
	private Bnode<E> parent;
	
	public BTree(int degree) {
		assert 2 <= degree;
		this.degree = degree;
		maximunDegree = 2 * degree;
		maximunKeys = maximunDegree - 1;
		Bnode.maximun_degree = maximunDegree;
		parent = null;
	}
	
	public void add(E key) {
		if(parent == null) {
			parent = new Bnode<>(key);
		} else {
			if(parent.keysFull()) {
				Bnode<E> leftChild = parent;
				Bnode<E> rightChild = leftChild.splitRightHalf();
				Bnode<E> newParent = new Bnode<>(false);
				newParent.addKey(rightChild.removeFirst());
				newParent.addChild(leftChild);
				newParent.addChild(rightChild);
				parent = newParent;
			}
			add(parent, key);
		}
	}

	private void add(Bnode<E> parent, E key) {
		if(parent.isLeaf()) {
			parent.addKey(key);
		} else {
			int index = 0;
			while(index < parent.keysSize() && lessThan(parent.getKey(index), key) ) {
				index++;
			}
			Bnode<E> child = parent.getChild(index);
			if (child.keysFull()) {
				Bnode<E> rightChild = child.splitRightHalf();
				E element = rightChild.removeFirst();
				parent.addKey(element);
				parent.addChildInIndex(rightChild, element);
			}
			if(index < parent.keysSize() && lessThan(parent.getKey(index), key)) {
				index++;
			}
			add(parent.getChild(index), key);
		}
	}

	private boolean lessThan(E parentKey, E key) {
		return parentKey.compareTo(key) == -1;
	}
	
	public void traverse() {
		parent.traverse();
	}
	
	
}
