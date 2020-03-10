package solver;

import java.util.Collection;

import entity.Estado;
import estruturas.EstruturaDeEstadosAbertos;

public class Busca {
	
	Estado estadoInicial;
	EstruturaDeEstadosAbertos ea;
	
	Estado solucao = null;
	
	int iteracoes = 0;
	
	public Busca(Estado aEstadoInicial, EstruturaDeEstadosAbertos aEa) {
		this.estadoInicial = aEstadoInicial;
		this.ea = aEa;
	}
	
	public void solve() {
		ea.push(estadoInicial);
		while(ea.size()>0) {
			iteracoes++;
			Estado proximoEstado = ea.pop();
			System.out.println("Verificando o estado na iteracao " + iteracoes);
			System.out.println(proximoEstado);
			if(proximoEstado.verificaObjetivo()) {
				this.solucao = proximoEstado;
				return;
			}
			Collection<Estado> filhos = proximoEstado.geraFilhos();
			for(Estado e : filhos) {
				ea.push(e);
			}
		}
	}
	
	public Estado getSolution() {
		return this.solucao;
	}

}
