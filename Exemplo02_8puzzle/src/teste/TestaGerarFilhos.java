package teste;

import java.util.List;

import dao.Dao;
import entity.Acao;
import entity.Estado;
import entity.Tabuleiro;

public class TestaGerarFilhos {
	
	public static void main(String[] args) {

		Dao dao = new Dao("instances/inst01.in");
		Tabuleiro tabuleiro = dao.getInstance();
		Estado estado = new Estado(tabuleiro);
		System.out.println(estado);
		
		List<Estado> filhos = estado.geraFilhos();
		Estado umFilho = null;
		for(Estado filho : filhos) {
			System.out.println(filho);
			umFilho = filho;
		}
		
		filhos = umFilho.geraFilhos();
		for(Estado filho : filhos) {
			System.out.println(filho);
		}
		
		
	}

}
