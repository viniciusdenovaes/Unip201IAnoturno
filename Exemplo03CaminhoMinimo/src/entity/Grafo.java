package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Grafo {
	
	Map<Vertice, Coordenada> vertices;
	Map<Vertice, List<Aresta>> arestas;
	
	public Grafo() {
		this.vertices = new TreeMap<>();
		this.arestas = new TreeMap<>();
	}
	
	public void addVertice(Vertice v, Coordenada c) {
		vertices.put(v, c);
		arestas.put(v, new ArrayList<>());
	}
	
	public void addAresta(Vertice v, Aresta a) {
		(arestas.get(v)).add(a);
	}

	@Override
	public String toString() {
		
		String res = "";
		
		for(Vertice v: vertices.keySet()) {
			res += v + " " + vertices.get(v) + "\n";
			for(Aresta a: arestas.get(v)) {
				res += "\t" + a + "\n"; 
			}
		}
		res += "\n";
		return res;
	}
	
	
	

}
