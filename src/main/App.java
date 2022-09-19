package main;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import trivial.HashTrivialNegative;

public class App {

	public static void main(String[] args) {
		//Hash doubleHash = new DoubleHash();
		
		//doubleHash.add(5);
		//doubleHash.add(10);
		//doubleHash.add(20);
		
		//doubleHash.remove(10);
		//doubleHash.add(0);
		
		//System.out.println(doubleHash.contain(20));
		//System.out.println(doubleHash.get(5));
		//System.out.println(doubleHash.get(20));
		//System.out.println("====================");

		//Hash linearHash = new LinearHash(8);
		//linearHash.add(400);
		//linearHash.add(800);
		//linearHash.add(800);
		//linearHash.add(800);
		//linearHash.add(300);
		//linearHash.add(300);
		//linearHash.add(300);
		//linearHash.add(4);
		//linearHash.add(10);
		//linearHash.add(10);
		//linearHash.add(10);
		//System.out.println(linearHash.get(400));
		//System.out.println(linearHash.get(800));
		//System.out.println(linearHash.get(10));
		//System.out.println(linearHash);
		//Map<String, Integer> maps = new Map<>();
		//maps.add("johan", 1);
		//maps.add("johan", 2);
		//maps.add("jean", 1);
		//maps.printMap();
		
		//System.out.println("hola".hashCode());
		//System.out.println("hol".hashCode());
		
		Map<String, Integer> map = new HashMap<>();
		
		map.put("johan", 1);
		map.put("jean", 1);
		
		
		System.out.println(map);
		System.out.println(map.entrySet());
		System.out.println(map.containsKey("johan"));
		System.out.println(map.size());
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println("key: " + key + ". value: " + val);
		}
		
		Map<String, Double> hashtable = new Hashtable<>();
		hashtable.put("valeria", 2.5);
		hashtable.put("omar", 1.5);
		
		System.out.println(hashtable);
	}

}
