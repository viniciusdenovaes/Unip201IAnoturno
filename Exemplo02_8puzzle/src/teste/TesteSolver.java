package teste;

import dao.Dao;
import entity.Estado;
import entity.Tabuleiro;
import estruturas.Fila;
import estruturas.FilaDePrioridade;
import estruturas.Pilha;
import solver.Solver;

public class TesteSolver {
	
	public static void main(String[] args) {
		Dao dao = new Dao("instances/inst01_100.in");
		Tabuleiro tabuleiro = dao.getInstance();
		Estado estado = new Estado(tabuleiro);
		System.out.println(estado);
//		Solver solver = new Solver(estado, new Fila());
		Solver solver = new Solver(estado, new FilaDePrioridade());
		solver.solve();
		System.out.println(solver.getObjetivo());
		
		System.out.println("iteracoes: " + solver.getIteracoes());

	}

}
