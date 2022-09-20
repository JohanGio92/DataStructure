package main;

import simple.Graph;

public class App {
	public static void main(String[] args) {
		System.out.println("hello world");
		
		Graph graph = new Graph();
		graph.display();
		System.out.println("==============");
		graph.addEdge("f", "t");
		graph.addEdge("a", "d");
		graph.display();
		System.out.println(graph);
		System.out.println(graph.getNeighbors("c"));
		System.out.println(graph.allEdges());
		System.out.println("==============");
		System.out.println(graph.getCamino("a", "b"));
	}
}
