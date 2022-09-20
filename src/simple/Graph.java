package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	private Map<String, List<String>> graph;
	private List<String> camino;
	
	public Graph() {
		camino = new ArrayList<>();
		fill();
	}

	private void fill() {
		graph = new HashMap<>();
		graph.put("a", new ArrayList<>(List.of("c")));
		graph.put("b", List.of("c", "e"));
		graph.put("c", List.of("a", "b", "d", "e"));
		graph.put("d", List.of("c"));
		graph.put("e", List.of("c", "b"));
		graph.put("f", new ArrayList<>(Arrays.asList()));
	}
	
	public void addEdge(String source, String target) {
		if (!graph.containsKey(source)) {
			graph.put(source, List.of(target));
		} else {
			assert !graph.get(source).contains(target);
			graph.get(source).add(target);
		}
	}
	
	public List<String> getNeighbors(String vertex){
		assert graph.containsKey(vertex);
		return graph.get(vertex);
	}
	

	public List<Map<String, String>> allEdges() {
		List<Map<String, String>> edges = new ArrayList<>();
		for (String vertice : graph.keySet()) {
			for (String vecino : graph.get(vertice)) {
				Map<String, String> pair = new HashMap<>();
				pair.put(vertice, vecino);
				edges.add(pair);
			}
		}
		return edges;
	}
	
	
	public List<String> getCamino(String originVertex, String targetVertex) {
		camino.clear();
		return getCamino(originVertex, targetVertex, camino);
		
	}
	public List<String> getCamino(String originVertex, 
			String targetVertex, List<String> camino) {

		camino.add(originVertex);
		if (originVertex.equals(targetVertex)) {
			return camino;
		}

		for (String vertex : graph.get(originVertex)) {
			if(!camino.contains(vertex)) {
				camino = getCamino(vertex, targetVertex, camino);
			}
		}
		return camino;
	}
	
	public void display(){
		for (String vertice : graph.keySet()) {
			for (String vecino : graph.get(vertice)) {
				System.out.println(vertice + "->" + vecino);
			}
			System.out.println();
		}
	}
	
	@Override
	public String toString() {
		return "" + graph;
	}
}
