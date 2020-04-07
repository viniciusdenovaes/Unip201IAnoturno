package teste;

import dao.Dao;
import entity.Acao;
import entity.Estado;
import entity.Tabuleiro;

public class TesteObjetivo {
	public static void main(String[] args) {
		Dao dao = new Dao("instances/inst01.in");
		Tabuleiro tabuleiro = dao.getInstance();
		Estado estado = new Estado(tabuleiro);
		System.out.println(estado);
		System.out.println(estado.isObjetivo());
		
		Estado ea = estado.deepCopy();
		ea.aplicarAcao(Acao.CIMA);
		System.out.println(ea);
		System.out.println(ea.isObjetivo());
		
		
	}
}
