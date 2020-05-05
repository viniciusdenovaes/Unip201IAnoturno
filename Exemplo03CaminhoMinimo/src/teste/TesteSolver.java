package teste;

import dao.Dao;
import entity.Caminho;
import entity.Estado;
import entity.Grafo;
import estruturas.Fila;
import estruturas.FilaDePrioridade;
import estruturas.Pilha;
import solver.Solver;

public class TesteSolver {
	
	public static void main(String[] args) {
		Dao dao = new Dao("instances/mapa.inst");
		Grafo g = dao.getInstance();
		System.out.println(g);
		
		Caminho c = new Caminho(g, g.getVertice("A"));
		Estado e = new Estado(g, c, null);
		
		Solver solver = new Solver(g, g.getVertice("A"), g.getVertice("B"));
//		solver.solve(new Fila());
//		solver.solve(new Pilha());
		solver.solve(new FilaDePrioridade());
		System.out.println("Solucao: " + solver.getSolution());
		System.out.println("Iteracoes: " + solver.getIteracoes());
		

	}

}
