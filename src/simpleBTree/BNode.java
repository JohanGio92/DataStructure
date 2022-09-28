package simpleBTree;

import org.w3c.dom.Node;

public class BNode {

	private int[] keys;
	private int keySize;
	private int minimunDegree;
	private int maximunDegree;
	private BNode[] childs;
	private boolean leaf;
	
	public BNode(int degree, boolean leaf) {
		minimunDegree = degree;
		maximunDegree = 2 * minimunDegree;

		this.leaf = leaf;
		this.keys = new int[maximunDegree - 1];
		this.childs = new BNode[maximunDegree];
		keySize = 0;
	}
	
	private BNode(BNode root) {
		this(root.minimunDegree, root.leaf);
	}

	public void addKey(int index, int key) {
		this.keys[index] = key;
	}
	
	public void setKeySize(int count) {
		keySize = count;
	}
	
	public int getKeySize() {
		return keySize;
	}
	
	public void traverse() {
		int i = 0;
		for (i = 0; i < keySize; i++) {
			if(!this.leaf) {
				childs[i].traverse();
			}
			System.out.println(keys[i]);
		}
		
		if(!this.leaf)
			childs[i].traverse();
	}
	
	public BNode hasNode(int key) {
		int i = 0;
		while (i < keySize && keys[i] < key) {
			i++;
		}
		if(keys[i] == key)
			return this;
		if(this.leaf)
			return null;
		return childs[i].hasNode(key);
	}
	
	public void splitChild(int index, BNode root) {
		BNode newNode = partialCopy(root);
		for (int i = keySize; index <= i; i--) {
			childs[i + 1] = childs[i];
		}
		childs[index + 1] = newNode;
		
		for (int i = keySize-1; index < i; i--) {
			keys[i+1] = keys[i]; 
		}
		
		keys[index] = root.keys[minimunDegree - 1];
	};

	private BNode partialCopy(BNode root) {
		BNode newNode = root.copy();
		int newSize = minimunDegree - 1;
		newNode.setKeySize(newSize);
		
		for(int i = 0; i < newSize; i++) {
			newNode.keys[i] = root.keys[i + newSize + 1];
		}
		
		if(!root.leaf) {
			for (int i = 0; i < newSize + 1; i++) {
				newNode.childs[i] = root.childs[i + newSize];
			}
		}
		root.setKeySize(newSize);
		return newNode;
	}
	
	public void addNotFull(int key) {
		int index = keySize - 1;
		if(leaf) {
			while (0 <= index && key < keys[index]) {
				keys[index + 1] = keys[index]; 
				index--;
			}
			keys[index + 1] = key;
			keySize++;
		} else {
			while (0 <= index && key < keys[index]) {
				index--;
			}
			
			if(childs[index + 1].keySize == maximunDegree-1) {
				splitChild(index + 1, childs[index + 1]);
				if(keys[index + 1] < key) {
					index++;
				}
			}
			childs[index + 1].addNotFull(key);
		}
	}

	public BNode getChild(int index) {
		return childs[index];
	}
	
	public void setChild(int index, BNode child) {
		childs[index] = child;
	}

	public int getKey(int index) {
		return keys[index];
	}
	
	public BNode copy() {
		return new BNode(this);
	}
}
