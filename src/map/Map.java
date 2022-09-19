package map;

import java.util.ArrayList;
import java.util.List;

public class Map<K, V> {

	private static final double DEFAULT_LOAD_FACTOR = 0.75;
	private static int MAX_BUCKETS = 5;
	private List<MapNode<K, V>> buckets;
	private int size;
	
	public Map() {
		buckets = new ArrayList<>(MAX_BUCKETS);
		fill();
	}
	
	private void fill() {
		for (int i = 0; i < MAX_BUCKETS; i++) {
			buckets.add(null);
		}
	}
	
	private int getHash(K key) {
		return key.hashCode() % MAX_BUCKETS;
	}
	
	private void resize() {
		MAX_BUCKETS *= 2;
		size = 0;
	}
	
	private double loadFactor() {
		return (1.0 * size) / MAX_BUCKETS;
	}
	
	public void add(K key, V value) {
		int hash = getHash(key);
		MapNode<K, V> head = buckets.get(hash);
		
		while(head != null) {
			if(head.getKey().equals(key)) {
				return;
			}
			head = head.getNext();
		}
		
		MapNode<K, V> newMapNode = new MapNode<K, V>(key, value);
		head = buckets.get(hash);
		newMapNode.setNext(head);
		buckets.set(hash, newMapNode);
		size++;
		
		if(loadFactor() > DEFAULT_LOAD_FACTOR) {
			rehash();
		}
	}
	
	private void rehash() {
        resize();
        List<MapNode<K, V> > current = buckets;
        buckets = new ArrayList<MapNode<K, V> >(MAX_BUCKETS);
        fill();

        for (int i = 0; i < current.size(); i++) {
            MapNode<K, V> head = current.get(i);
            while (head != null) {
                K key = head.getKey();
                V val = head.getValue();
                add(key, val);
                head = head.getNext();
            }
        }
	}
	
	public V getValue(K key){
		int hash = getHash(key);
		MapNode<K,V> iterator = buckets.get(hash);
		while(iterator != null){
			if(iterator.getKey().equals(key)){
				return iterator.getValue();
			}
			iterator = iterator.getNext();
		}
		return null;
	}

	public void printMap() {
        List<MapNode<K, V> > temp = buckets;
        System.out.println("Current HashMap:");
        for (int i = 0; i < temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);
            while (head != null) {
                System.out.println("key = " + head.getKey() + ", val = " + head.getValue());
                head = head.getNext();
            }
            System.out.println("=====================================");
        }
        System.out.println();
    }
}
