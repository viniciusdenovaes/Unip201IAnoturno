package teste;

import java.util.Collection;

import dao.Dao;
import entity.Estado;
import entity.Tabuleiro;

public class testeEstado {
	
	public static void main(String[] args) {
		testaGeraFilhos();
	}
	
	static void testaGeraFilhos() {
		String path = "instances/s01a.txt";
		Dao dao = new Dao(path);
		Tabuleiro tabuleiro = dao.getInstance();
		Estado estado = new Estado(tabuleiro);
		
		Collection<Estado> filhos = estado.geraFilhos();
		
		System.out.println(filhos.size());
		Estado f = null; 
		for(Estado e : filhos) {
			f = e;
			System.out.println(e);
		}
		
		Collection<Estado> filhosF = f.geraFilhos();
		
		System.out.println(filhosF.size());
		for(Estado e : filhosF) {
			System.out.println(e);
		}
		
	}

}
