package entity;

import java.util.ArrayList;
import java.util.List;

public class Estado {
	
	private Grafo grafo;
	private Caminho caminho;
	private Vertice destino;
	
	public Estado(Grafo aGrafo, Caminho aCaminho, Vertice aDestino) {
		this.grafo = aGrafo;
		caminho = aCaminho;
		this.destino = aDestino;
	}
	
	public Caminho getCaminho() {
		return this.caminho;
	}
	
	public double getCustoCaminho() {
		return this.getCaminho().getCusto();
	}
	
	public List<Estado> geraFilhos(){
		
		List<Estado> filhos = new ArrayList<>();
		Vertice ultimo = caminho.getFinal();
		
		for(Vertice v: grafo.getVertices()) {
			if(caminho.contains(v)) continue;
			if(grafo.adjacentes(v, ultimo)) {
				Estado filho = deepCopy();
				filho.caminho.addVertice(v);
				filhos.add(filho);
			}
		}
		
		return filhos;
	}
	
	public Vertice getDestino() {
		return this.destino;
	}
	
	public Estado deepCopy() {
		Caminho novoCaminho = this.caminho.deepCopy();
		Estado novo = new Estado(grafo, novoCaminho, this.destino);
		return novo;
	}
	
	@Override
	public String toString() {
		return caminho.toString();
	}

}
