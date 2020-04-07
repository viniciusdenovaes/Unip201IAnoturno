package teste;

import dao.Dao;
import entity.Tabuleiro;

public class TesteDao {
	
	public static void main(String[] args) {
		Dao dao = new Dao("instances/inst01.in");
		Tabuleiro tabuleiro = dao.getInstance();
		System.out.println(tabuleiro);
		
	}

}
