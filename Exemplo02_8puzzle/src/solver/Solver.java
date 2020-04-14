package solver;

import java.util.ArrayList;
import java.util.List;

import entity.Acao;
import entity.Estado;
import estruturas.EstruturaDeEstadosAbertos;

public class Solver {
	
	private Estado estadoInicial;
	private Estado estadoObjetivo;
	EstruturaDeEstadosAbertos eea;
	private int iteracoes;
	
	private List<Acao> solucao; 
	
	public Solver(Estado aEstado, EstruturaDeEstadosAbertos aEEA) {
		this.estadoInicial = aEstado;
		this.eea = aEEA;
	}
	
	public void solve() {
		iteracoes = 0;
		eea.push(estadoInicial);
		while(eea.size()>0) {
			Estado estado = eea.pop();
			iteracoes++;
			System.out.println("Estudando o estado" + estado);
			if(estado.isObjetivo()) {
				this.estadoObjetivo = estado;
				return;
			}
			List<Estado> filhos = estado.geraFilhos();
			for(Estado filho: filhos) {
				eea.push(filho);
			}
				
		}
	}
	
	public Estado getObjetivo() {
		return this.estadoObjetivo;
	}
	
	public List<Acao> getSolution() {
		return null;
	}
	
	public int getIteracoes() {
		return this.iteracoes;
	}

}
