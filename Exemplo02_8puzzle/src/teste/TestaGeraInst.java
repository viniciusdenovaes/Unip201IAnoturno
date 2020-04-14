package teste;

import java.util.List;
import java.util.Random;

import dao.Dao;
import entity.Estado;
import entity.Tabuleiro;

public class TestaGeraInst {
	public static void main(String[] args) {

		Dao dao = new Dao("instances/inst01.in");
		Tabuleiro tabuleiro = dao.getInstance();
		Estado estado = new Estado(tabuleiro);
		System.out.println(estado);
		
		int passos = 100;
		
		for(int i=0; i<passos; i++) {
			List<Estado> filhos = estado.geraFilhos();
			int escolhido = new Random().nextInt(filhos.size());
			estado = filhos.get(escolhido);
		}
		
		System.out.println(estado);
		
		
	}


}
