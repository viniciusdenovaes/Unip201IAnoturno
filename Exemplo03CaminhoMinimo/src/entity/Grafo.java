package entity;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Grafo {
	
	private Map<Integer, Vertice> vertices;
	private Map<String, Vertice> nomes;
	private int size;
	private double[][] adj;
	
	public Grafo(int aSize) {
		
		this.vertices = new TreeMap<>();
		this.nomes = new TreeMap<>();
		this.size = aSize;
		adj = new double[size][size];
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				adj[i][j] = -1.0;
			}
		}
	}
	
	public double getAdj(int i, int j){
		return adj[i][j];
	}
	
	public void addVertice(Vertice v) {
		vertices.put(v.getId(), v);
		nomes.put(v.getNome(), v);
	}
	
	public Vertice getVertice(String nome) {
		return this.nomes.get(nome);
	}
	
	public Collection<Vertice> getVertices(){
		return vertices.values();
	}
	
	public boolean adjacentes(Vertice v1, Vertice v2) {
		return adj[v1.getId()][v2.getId()] > 0;
	}
	
	public void addAresta(Vertice v1, Vertice v2, double valor) {
		adj[v1.getId()][v2.getId()] = valor;
		adj[v2.getId()][v1.getId()] = valor;
	}
	
	public static double distanciaVertice(Vertice v1, Vertice v2) {
		return distancia(v1.getCorrdenada(), v2.getCorrdenada());
	}
	
	public static double distancia(Coordenada c1, Coordenada c2) {
		double res; 
		res = Math.pow((c1.x - c2.x), 2) + Math.pow((c1.y - c2.y), 2);
		res = Math.sqrt(res);
		return res;
	}

	@Override
	public String toString() {
		
		String res = "";
		
		for(int i=0; i<size; i++) {
			res += vertices.get(i) + "\n";
			for(int j=0; j<size; j++) {
				if(adj[i][j]>0 && i!=j) {
					res += "\t" + "para o vertice " + vertices.get(j).getNome() + ", valor " + adj[i][j] + "\n";
				}
			}
		}
		res += "\n";
		return res;
	}
	
	
	

}
