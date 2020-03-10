package teste;

import dao.Dao;
import entity.Estado;
import entity.Tabuleiro;
import estruturas.EstruturaDeEstadosAbertos;
import estruturas.Fila;
import estruturas.Pilha;
import solver.Busca;

public class TesteSolverBusca {
	
	public static void main(String[] args) {
//		testePilha();
		testeFila();
	}
	
	static void testeFila() {
		String path = "instances/s12a.txt";
		Dao dao = new Dao(path);
		Tabuleiro tabuleiro = dao.getInstance();
		Estado estadoInicial = new Estado(tabuleiro);
		
		EstruturaDeEstadosAbertos ea = new Fila();
		System.out.println("Comecando com o estado ");
		System.out.println(estadoInicial);

		Busca busca = new Busca(estadoInicial, ea);
		busca.solve();
		Estado solucao = busca.getSolution();
		System.out.println("Solucao: ");
		System.out.println(solucao);
	}
	
	static void testePilha() {
		String path = "instances/s12a.txt";
		Dao dao = new Dao(path);
		Tabuleiro tabuleiro = dao.getInstance();
		Estado estadoInicial = new Estado(tabuleiro);
		
		EstruturaDeEstadosAbertos ea = new Pilha();
		System.out.println("Comecando com o estado ");
		System.out.println(estadoInicial);

		Busca busca = new Busca(estadoInicial, ea);
		busca.solve();
		Estado solucao = busca.getSolution();
		System.out.println("Solucao: ");
		System.out.println(solucao);
	}

}
