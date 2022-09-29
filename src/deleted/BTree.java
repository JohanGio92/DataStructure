package deleted;

//Inserting a key on a B-tree in Java

import java.util.Stack;

public class BTree {

	private int minimunDegree;

	public class Node {
		int keySize;
		int keys[] = new int[2 * minimunDegree - 1];
		Node childs[] = new Node[2 * minimunDegree];
		boolean leaf = true;

		public int Find(int k) {
			for (int i = 0; i < this.keySize; i++) {
				if (this.keys[i] == k) {
					return i;
				}
			}
			return -1;
		};
	}

	public BTree(int degree) {
		minimunDegree = degree;
		root = new Node();
		root.keySize = 0;
		root.leaf = true;
	}

	private Node root;

	// Search the key
	private Node Search(Node parent, int key) {
		int i = 0;
		if (parent == null)
			return parent;
		for (i = 0; i < parent.keySize; i++) {
			if (key < parent.keys[i]) {
				break;
			}
			if (key == parent.keys[i]) {
				return parent;
			}
		}
		if (parent.leaf) {
			return null;
		} else {
			return Search(parent.childs[i], key);
		}
	}

	// Split function
	private void Split(Node parent, int index, Node fullLeftChild) {
		Node rightChild = new Node();
		rightChild.leaf = fullLeftChild.leaf;
		rightChild.keySize = minimunDegree - 1;
		for (int j = 0; j < minimunDegree - 1; j++) {
			rightChild.keys[j] = fullLeftChild.keys[j + minimunDegree];
		}
		if (!fullLeftChild.leaf) {
			for (int j = 0; j < minimunDegree; j++) {
				rightChild.childs[j] = fullLeftChild.childs[j + minimunDegree];
			}
		}
		fullLeftChild.keySize = minimunDegree - 1;
		for (int j = parent.keySize; j >= index + 1; j--) {
			parent.childs[j + 1] = parent.childs[j];
		}
		parent.childs[index + 1] = rightChild;

		for (int j = parent.keySize - 1; j >= index; j--) {
			parent.keys[j + 1] = parent.keys[j];
		}
		parent.keys[index] = fullLeftChild.keys[minimunDegree - 1];
		parent.keySize = parent.keySize + 1;
	}

	// Insert the key
	public void Insert(final int key) {
		Node r = root;
		if (r.keySize == 2 * minimunDegree - 1) {
			Node s = new Node();
			root = s;
			s.leaf = false;
			s.keySize = 0;
			s.childs[0] = r;
			Split(s, 0, r);
			_Insert(s, key);
		} else {
			_Insert(r, key);
		}
	}

	// Insert the node
	final private void _Insert(Node x, int k) {

		if (x.leaf) {
			int i = 0;
			for (i = x.keySize - 1; i >= 0 && k < x.keys[i]; i--) {
				x.keys[i + 1] = x.keys[i];
			}
			x.keys[i + 1] = k;
			x.keySize = x.keySize + 1;
		} else {
			int i = 0;
			for (i = x.keySize - 1; i >= 0 && k < x.keys[i]; i--) {
			}
			;
			i++;
			Node tmp = x.childs[i];
			if (tmp.keySize == 2 * minimunDegree - 1) {
				Split(x, i, tmp);
				if (k > x.keys[i]) {
					i++;
				}
			}
			_Insert(x.childs[i], k);
		}

	}

	public void Show() {
		Show(root);
	}

	private void Remove(Node x, int key) {
		int pos = x.Find(key);
		if (pos != -1) {
			if (x.leaf) {
				int i = 0;
				for (i = 0; i < x.keySize && x.keys[i] != key; i++) {
				}
				;
				for (; i < x.keySize; i++) {
					if (i != 2 * minimunDegree - 2) {
						x.keys[i] = x.keys[i + 1];
					}
				}
				x.keySize--;
				return;
			}
			if (!x.leaf) {

				Node pred = x.childs[pos];
				int predKey = 0;
				if (pred.keySize >= minimunDegree) {
					for (;;) {
						if (pred.leaf) {
							System.out.println(pred.keySize);
							predKey = pred.keys[pred.keySize - 1];
							break;
						} else {
							pred = pred.childs[pred.keySize];
						}
					}
					Remove(pred, predKey);
					x.keys[pos] = predKey;
					return;
				}

				Node nextNode = x.childs[pos + 1];
				if (nextNode.keySize >= minimunDegree) {
					int nextKey = nextNode.keys[0];
					if (!nextNode.leaf) {
						nextNode = nextNode.childs[0];
						for (;;) {
							if (nextNode.leaf) {
								nextKey = nextNode.keys[nextNode.keySize - 1];
								break;
							} else {
								nextNode = nextNode.childs[nextNode.keySize];
							}
						}
					}
					Remove(nextNode, nextKey);
					x.keys[pos] = nextKey;
					return;
				}

				int temp = pred.keySize + 1;
				pred.keys[pred.keySize++] = x.keys[pos];
				for (int i = 0, j = pred.keySize; i < nextNode.keySize; i++) {
					pred.keys[j++] = nextNode.keys[i];
					pred.keySize++;
				}
				for (int i = 0; i < nextNode.keySize + 1; i++) {
					pred.childs[temp++] = nextNode.childs[i];
				}

				x.childs[pos] = pred;
				for (int i = pos; i < x.keySize; i++) {
					if (i != 2 * minimunDegree - 2) {
						x.keys[i] = x.keys[i + 1];
					}
				}
				for (int i = pos + 1; i < x.keySize + 1; i++) {
					if (i != 2 * minimunDegree - 1) {
						x.childs[i] = x.childs[i + 1];
					}
				}
				x.keySize--;
				if (x.keySize == 0) {
					if (x == root) {
						root = x.childs[0];
					}
					x = x.childs[0];
				}
				Remove(pred, key);
				return;
			}
		} else {
			for (pos = 0; pos < x.keySize; pos++) {
				if (x.keys[pos] > key) {
					break;
				}
			}
			Node tmp = x.childs[pos];
			if (tmp.keySize >= minimunDegree) {
				Remove(tmp, key);
				return;
			}
			if (true) {
				Node nb = null;
				int devider = -1;

				if (pos != x.keySize && x.childs[pos + 1].keySize >= minimunDegree) {
					devider = x.keys[pos];
					nb = x.childs[pos + 1];
					x.keys[pos] = nb.keys[0];
					tmp.keys[tmp.keySize++] = devider;
					tmp.childs[tmp.keySize] = nb.childs[0];
					for (int i = 1; i < nb.keySize; i++) {
						nb.keys[i - 1] = nb.keys[i];
					}
					for (int i = 1; i <= nb.keySize; i++) {
						nb.childs[i - 1] = nb.childs[i];
					}
					nb.keySize--;
					Remove(tmp, key);
					return;
				} else if (pos != 0 && x.childs[pos - 1].keySize >= minimunDegree) {

					devider = x.keys[pos - 1];
					nb = x.childs[pos - 1];
					x.keys[pos - 1] = nb.keys[nb.keySize - 1];
					Node child = nb.childs[nb.keySize];
					nb.keySize--;

					for (int i = tmp.keySize; i > 0; i--) {
						tmp.keys[i] = tmp.keys[i - 1];
					}
					tmp.keys[0] = devider;
					for (int i = tmp.keySize + 1; i > 0; i--) {
						tmp.childs[i] = tmp.childs[i - 1];
					}
					tmp.childs[0] = child;
					tmp.keySize++;
					Remove(tmp, key);
					return;
				} else {
					Node lt = null;
					Node rt = null;
					boolean last = false;
					if (pos != x.keySize) {
						devider = x.keys[pos];
						lt = x.childs[pos];
						rt = x.childs[pos + 1];
					} else {
						devider = x.keys[pos - 1];
						rt = x.childs[pos];
						lt = x.childs[pos - 1];
						last = true;
						pos--;
					}
					for (int i = pos; i < x.keySize - 1; i++) {
						x.keys[i] = x.keys[i + 1];
					}
					for (int i = pos + 1; i < x.keySize; i++) {
						x.childs[i] = x.childs[i + 1];
					}
					x.keySize--;
					lt.keys[lt.keySize++] = devider;

					for (int i = 0, j = lt.keySize; i < rt.keySize + 1; i++, j++) {
						if (i < rt.keySize) {
							lt.keys[j] = rt.keys[i];
						}
						lt.childs[j] = rt.childs[i];
					}
					lt.keySize += rt.keySize;
					if (x.keySize == 0) {
						if (x == root) {
							root = x.childs[0];
						}
						x = x.childs[0];
					}
					Remove(lt, key);
					return;
				}
			}
		}
	}

	public void Remove(int key) {
		Node x = Search(root, key);
		if (x == null) {
			return;
		}
		Remove(root, key);
	}

	public void Task(int a, int b) {
		Stack<Integer> st = new Stack<>();
		FindKeys(a, b, root, st);
		while (st.isEmpty() == false) {
			this.Remove(root, st.pop());
		}
	}

	private void FindKeys(int a, int b, Node x, Stack<Integer> st) {
		int i = 0;
		for (i = 0; i < x.keySize && x.keys[i] < b; i++) {
			if (x.keys[i] > a) {
				st.push(x.keys[i]);
			}
		}
		if (!x.leaf) {
			for (int j = 0; j < i + 1; j++) {
				FindKeys(a, b, x.childs[j], st);
			}
		}
	}

	public boolean Contain(int k) {
		if (this.Search(root, k) != null) {
			return true;
		} else {
			return false;
		}
	}

	// Show the node
	private void Show(Node x) {
		assert (x == null);
		for (int i = 0; i < x.keySize; i++) {
			System.out.print(x.keys[i] + " ");
		}
		if (!x.leaf) {
			for (int i = 0; i < x.keySize + 1; i++) {
				Show(x.childs[i]);
			}
		}
	}

	public static void main(String[] args) {
		BTree b = new BTree(3);
		b.Insert(8);
		b.Insert(9);
		b.Insert(10);
		b.Insert(11);
		b.Insert(15);
		b.Insert(20);
		b.Insert(17);

		b.Show();

		b.Remove(10);
		System.out.println();
		b.Show();
	}
}
