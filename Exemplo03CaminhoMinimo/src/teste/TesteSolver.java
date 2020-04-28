package teste;

import dao.Dao;
import entity.Caminho;
import entity.Estado;
import entity.Grafo;
import solver.Solver;

public class TesteSolver {
	
	public static void main(String[] args) {
		Dao dao = new Dao("instances/mapa.inst");
		Grafo g = dao.getInstance();
		System.out.println(g);
		
		Caminho c = new Caminho(g, g.getVertice("A"));
		Estado e = new Estado(g, c);
		
		Solver solver = new Solver(g, g.getVertice("A"), g.getVertice("N"));
		solver.solve();
		System.out.println("Solucao: " + solver.getSolution());
		

	}

}
