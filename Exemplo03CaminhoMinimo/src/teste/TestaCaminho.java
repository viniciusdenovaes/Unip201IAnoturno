package teste;

import java.util.List;
import java.util.Random;

import dao.Dao;
import entity.Caminho;
import entity.Grafo;

public class TestaCaminho {
	public static void main(String[] args) {

		Dao dao = new Dao("instances/mapa.inst");
		Grafo g = dao.getInstance();
		
		Caminho c = new Caminho(g, g.getVertice("A"));
		c.addVertice(g.getVertice("S"));
		c.addVertice(g.getVertice("F"));
		c.addVertice(g.getVertice("B"));
		
		System.out.println(c);
		
		
		
	}


}
