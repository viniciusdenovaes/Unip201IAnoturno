package teste;

import java.util.List;
import java.util.Random;

import dao.Dao;
import entity.Grafo;

public class TestaGeraInst {
	public static void main(String[] args) {

		Dao dao = new Dao("instances/mapa.inst");
		Grafo g = dao.getInstance();
		
		System.out.println(g);
		
		
	}


}
