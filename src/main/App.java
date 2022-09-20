package main;

import disjoint.DisjointSet;
import disjoint.DisjointTreeSet;

public class App {

	public static void main(String[] args) {
		//int size = 5;
        //DisjointSet disjointSet =
        //        new DisjointSet(size);
        //// 0 is a friend of 2
        //disjointSet.union(0, 2);
        //// 4 is a friend of 2
        //disjointSet.union(4, 2);
        //// 3 is a friend of 1
        //disjointSet.union(3, 1);
        //// Check if 4 is a friend of 0
        //if (disjointSet.find(4) == disjointSet.find(0))
        //    System.out.println("Yes");
        //else
        //    System.out.println("No");

        //if (disjointSet.find(1) == disjointSet.find(0))
        //    System.out.println("Yes");
        //else
        //    System.out.println("No");
		
		DisjointTreeSet disjointTreeSet = new DisjointTreeSet();

        disjointTreeSet.makeSet(1);
        disjointTreeSet.makeSet(2);
        disjointTreeSet.makeSet(3);
        disjointTreeSet.makeSet(4);
        disjointTreeSet.makeSet(5);
        disjointTreeSet.makeSet(6);
        disjointTreeSet.makeSet(7);

        disjointTreeSet.union(1, 2);
        disjointTreeSet.union(2, 3);
        disjointTreeSet.union(4, 5);
        disjointTreeSet.union(6, 7);
        disjointTreeSet.union(5, 6);
        disjointTreeSet.union(3, 7);

        System.out.println(disjointTreeSet.findSet(1));
        System.out.println(disjointTreeSet.findSet(2));
        System.out.println(disjointTreeSet.findSet(3));
        System.out.println(disjointTreeSet.findSet(4));
        System.out.println(disjointTreeSet.findSet(5));
        System.out.println(disjointTreeSet.findSet(6));
        System.out.println(disjointTreeSet.findSet(7));
    }
}
