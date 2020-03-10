package teste;

import dao.Dao;
import entity.Tabuleiro;

public class testeTabuleiro {
	
	public static void main(String[] args) {
		testaProximaVazia();
		
	}
	
	static void testaProximaVazia() {
		String path = "instances/s01a.txt";
		Dao dao = new Dao(path);
		Tabuleiro t = dao.getInstance();
		System.out.println(t.getProximaVazia());
		Tabuleiro t1 = t.deepCopy();
		t1.setCell(0, 0, 1);
		System.out.println(t1.getProximaVazia());
		Tabuleiro t2 = t.deepCopy();
		t2.setCell(1, 1, 9);
		System.out.println(t2.getProximaVazia());
		
	}
	
	static void testaCelulaValida() {
		String path = "instances/s01a.txt";
		Dao dao = new Dao(path);
		Tabuleiro t = dao.getInstance();
		
		System.out.println(t.verificaCelulaValida(0, 0, 1));
		System.out.println(t.verificaCelulaValida(0, 0, 5));
		System.out.println(t.verificaCelulaValida(0, 0, 2));
		System.out.println(t.verificaCelulaValida(0, 0, 8));
	}
	
	static void testaCopiaTabuleiro() {
		String path = "instances/s01a.txt";
		Dao dao = new Dao(path);
		Tabuleiro t = dao.getInstance();
		System.out.println(t);
		Tabuleiro t1 = t.deepCopy();
		t1.setCell(0, 0, 1);
		Tabuleiro t2 = t.deepCopy();
		t2.setCell(1, 1, 9);
		
		System.out.println("t\n" + t + "\n");
		System.out.println("t1\n" + t1 + "\n");
		System.out.println("t2\n" + t2 + "\n");
		
	}
	static void testaVerificaLinha() {
		String path = "instances/s01a.txt";
		Dao dao = new Dao(path);
		Tabuleiro t = dao.getInstance();
		
		System.out.println("t eh valido na linha 0? " + t.verificaLinha(0));
		System.out.println(t);
		t.setCell(0, 0, 9);
		System.out.println("t eh valido na linha 0? " + t.verificaLinha(0));
		System.out.println();
		System.out.println(t);
	}
	static void testaVerificaColuna() {
		String path = "instances/s01a.txt";
		Dao dao = new Dao(path);
		Tabuleiro t = dao.getInstance();
		
		System.out.println("t eh valido na coluna 0? " + t.verificaColuna(0));
		System.out.println(t);
		t.setCell(0, 0, 9);
		System.out.println("t eh valido na coluna 0? " + t.verificaColuna(0));
		System.out.println();
		System.out.println(t);
	}
	static void testaVerificaQuadrante() {
		String path = "instances/s01a.txt";
		Dao dao = new Dao(path);
		Tabuleiro t = dao.getInstance();
		
		System.out.println("t eh valido no quadrante 1x2? " + t.verificaQuadranteDaCelula(4, 6));
		System.out.println(t);
		t.setCell(4, 6, 1);
		System.out.println("t eh valido no quadrante 1x2? " + t.verificaQuadranteDaCelula(4, 6));
		System.out.println();
		System.out.println(t);
	}
	
	

}
