package solver;

import java.util.List;

import entity.Acao;
import entity.Estado;
import estruturas.EstruturaDeEstadosAbertos;

public class Solver {
	
	private Estado estadoInicial;
	private Estado estadoObjetivo;
	EstruturaDeEstadosAbertos eea;
	
	public Solver(Estado aEstado, EstruturaDeEstadosAbertos aEEA) {
		this.estadoInicial = aEstado;
		this.eea = aEEA;
	}
	
	public void solve() {
		eea.push(estadoInicial);
		while(eea.size()>0) {
			Estado estado = eea.pop();
			if(estado.isObjetivo()) {
				this.estadoObjetivo = estado;
				return;
			}
			List<Estado> filhos = estado.geraFilhos();
			for(Estado filho: filhos) {
				System.out.println("colocando o estado " + filho);
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

}
