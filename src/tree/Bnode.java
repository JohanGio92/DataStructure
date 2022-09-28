package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bnode<E extends Comparable<E>> {
	
	public static int maximun_degree;
	private static int maximun_keys;
	private List<E> keys;
	private List<Bnode<E>> childs;
	private boolean leaf;
	
	public Bnode(boolean leaf) {
		this.leaf = leaf;
		keys = new ArrayList<>();
		childs = new ArrayList<>();
		maximun_keys = maximun_degree - 1;
	}
	
	public Bnode(E key) {
		this(true);
		keys.add(key);
	}
	
	public void addKey(E key) {
		//assert !keysFull();
		keys.add(key);
		Collections.sort(keys);
	}

	public E removeFirst() {
		E key = keys.remove(0);
		return key;
	}
	
	public void addChild(Bnode<E> child) {
		childs.add(child);
	}

	public void addChildInIndex(Bnode<E> child, E key) {
		int index = keys.indexOf(key);
		childs.add(index + 1, child);
	}
	
	public boolean keysFull() {
		return maximun_keys == keys.size();
	}
	
	public void split(Bnode<E> fullLeftChild, int index) {
		Bnode<E> rightChild = splitRightHalf(fullLeftChild);
		this.childs.add(rightChild);
	}

	public E removeMiddle() {
		return keys.remove(maximun_keys/2);
	}

	private Bnode<E> splitRightHalf(Bnode<E> fullLeftChild) {
		int center = maximun_keys/2;
		Bnode<E> rightChild = new Bnode<>(leaf);
		
		for(int index = center; index < maximun_keys; index++) {
			rightChild.addKey(fullLeftChild.keys.remove(center));
		}
		
		if(!fullLeftChild.leaf) {
			for(int index = center; index < maximun_keys; index++) {
				rightChild.addChild(fullLeftChild.childs.remove(center + 1));
			}
		}
		return rightChild;
	}
	
	
	public Bnode<E> splitRightHalf() {
		return splitRightHalf(this);
	}

	public boolean isLeaf() {
		return leaf;
	}

	public E getKey(int index) {
		return keys.get(index);
	}
	
	public Bnode<E>getChild(int index) {
		return childs.get(index);
	}
	
	public int keysSize() {
		return this.keys.size();
	}

	public int childsSize() {
		return this.childs.size();
	}
	
	public void add(Bnode<E> child) {
		
	}
	
	public void traverse() {
		int i = 0;
		for (i = 0; i < keysSize(); i++) {
			if(!this.leaf) {
				childs.get(i).traverse();
			}
			System.out.println(keys.get(i));
		}
		
		if(!this.leaf)
			childs.get(i).traverse();
	}
}
