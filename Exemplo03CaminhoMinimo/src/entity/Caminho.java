package entity;

import java.util.ArrayList;
import java.util.List;

public class Caminho {
	
	private Grafo grafo;
	private List<Vertice> vertices;
	private double custo;
	
	public Caminho(Grafo aGrafo, Vertice v) {
		this.grafo = aGrafo;
		this.vertices = new ArrayList<>();
		this.vertices.add(v);
		this.custo = 0;
	}
	
	public List<Vertice> getVertices(){
		return this.vertices;
	}
	
	public double getCusto() {
		return this.custo;
	}
	
	public void addVertice(Vertice v) {
		Vertice ultimoVertice = getFinal();
		vertices.add(v);
		double custoAresta = grafo.getAdj(ultimoVertice.getId(), v.getId());
		custo += custoAresta;
	}
	
	public boolean contains(Vertice v) {
		return vertices.contains(v);
	}
	
	public Vertice getInicial() {
		return vertices.get(0);
	}
	
	public Vertice getFinal() {
		return vertices.get(vertices.size()-1);
	}
	
	public Caminho deepCopy() {
		Caminho novo = new Caminho(this.grafo, getInicial());
		for(int i=1; i<vertices.size(); i++) {
			novo.addVertice(vertices.get(i));
		}
		return novo;
	}
	
	@Override
	public String toString() {
		String res = "";
		res += "Caminho (" + custo + "): [";
		for(Vertice v: vertices) {
			res += v.getNome() + ", ";
		}
		res += "]";
		return res;
	}

}
