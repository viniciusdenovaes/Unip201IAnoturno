package solver;

import entity.Estado;
import entity.Grafo;
import entity.Vertice;

public class HeuristicasDeAvaliacao {
	
	public static double g(Estado estado) {
		return estado.getCustoCaminho();
	}
	
	public static double h0(Estado estado) {
		return 0;
	}
	
	public static double h1(Estado estado) {
		Vertice ultimo = estado.getCaminho().getFinal();
		return Grafo.distanciaVertice(ultimo, estado.getDestino());
	}
	
	public static double f(Estado estado) {
		return g(estado) + h1(estado);
	}

}
