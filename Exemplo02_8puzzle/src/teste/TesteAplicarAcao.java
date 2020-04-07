package teste;

import dao.Dao;
import entity.Acao;
import entity.Estado;
import entity.Tabuleiro;

public class TesteAplicarAcao {
	
	public static void main(String[] args) {
		
		Dao dao = new Dao("instances/inst01.in");
		Tabuleiro tabuleiro = dao.getInstance();
		Estado estado = new Estado(tabuleiro);
		System.out.println(estado);
		
		Estado ea = estado.deepCopy();
		ea.aplicarAcao(Acao.CIMA);
		System.out.println(ea);
		
		ea.aplicarAcao(Acao.ESQUERDA);
		System.out.println(ea);
		
		ea.aplicarAcao(Acao.BAIXO);
		System.out.println(ea);
		
		ea.aplicarAcao(Acao.DIREITA);
		System.out.println(ea);
		
	}

}
