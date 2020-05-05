package teste;

import java.util.List;

import dao.Dao;
import entity.Caminho;
import entity.Estado;
import entity.Grafo;

public class TesteGerarFilhos {
	
	public static void main(String[] args) {
		
		Dao dao = new Dao("instances/mapa.inst");
		Grafo g = dao.getInstance();
		
		Caminho c = new Caminho(g, g.getVertice("A"));
		Estado e = new Estado(g, c, null);
		
		System.out.println(e);
		
		List<Estado> filhos = e.geraFilhos();
		Estado umFilho = null;
		for(Estado estado: filhos) {
			System.out.println(estado);
			umFilho = estado;
		}
		
		filhos = umFilho.geraFilhos();
		for(Estado estado: filhos) {
			System.out.println(estado);
			umFilho = estado;
		}
		
		
		filhos = umFilho.geraFilhos();
		for(Estado estado: filhos) {
			System.out.println(estado);
			umFilho = estado;
		}
		
		
		filhos = umFilho.geraFilhos();
		for(Estado estado: filhos) {
			System.out.println(estado);
			umFilho = estado;
		}
		
	}
	

}
