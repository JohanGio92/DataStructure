package main;


import doublehash.DoubleHash;
import doublehash.Hash;
import doublehash.LinearHash;

public class App {

	public static void main(String[] args) {
		Hash doubleHash = new DoubleHash();
		
		doubleHash.add(5);
		doubleHash.add(10);
		doubleHash.add(20);
		
		doubleHash.remove(10);
		doubleHash.add(0);
		
		System.out.println(doubleHash.contain(20));
		System.out.println(doubleHash.get(5));
		System.out.println(doubleHash.get(20));
		System.out.println("====================");

		Hash linearHash = new LinearHash(8);
		linearHash.add(400);
		linearHash.add(800);
		linearHash.add(800);
		linearHash.add(800);
		linearHash.add(300);
		linearHash.add(300);
		linearHash.add(300);
		linearHash.add(4);
		linearHash.add(10);
		linearHash.add(10);
		linearHash.add(10);
		System.out.println(linearHash.get(400));
		System.out.println(linearHash.get(800));
		System.out.println(linearHash.get(10));
		System.out.println(linearHash);
	}

}
