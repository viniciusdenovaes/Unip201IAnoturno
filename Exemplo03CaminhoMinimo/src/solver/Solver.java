package solver;

import java.util.List;

import entity.Caminho;
import entity.Estado;
import entity.Grafo;
import entity.Vertice;
import estruturas.EstruturaDeEstadosAbertos;
import estruturas.Fila;
import estruturas.Pilha;

public class Solver {
	
	Grafo grafo;
	Vertice origem, destino;
	Caminho solucao;
	
	public Solver(Grafo aGrafo, Vertice aOrigem, Vertice aDestino) {
		this.grafo = aGrafo;
		this.origem = aOrigem;
		this.destino = aDestino;
	}
	
	public boolean isObjetivo(Estado e) {
		Caminho c = e.getCaminho();
		return c.getFinal().equals(destino);
	}
	
	public void solve() {
		Estado inicial = new Estado(grafo, new Caminho(grafo, origem));
		EstruturaDeEstadosAbertos eea = new Fila();
		eea.push(inicial);
		while(eea.size()>0) {
			Estado e = eea.pop();
			if(isObjetivo(e)) {
				solucao = e.getCaminho();
				return;
			}
			List<Estado> filhos = e.geraFilhos();
			for(Estado filho: filhos) {
				eea.push(filho);
			}
		}
	}
	
	public Caminho getSolution() {
		return solucao;
	}
	
	

}
