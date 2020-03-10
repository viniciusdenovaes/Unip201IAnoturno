package entity;

import java.util.ArrayList;
import java.util.Collection;

import entity.Tabuleiro.Coordenada;

public class Estado {
	
	Tabuleiro tabuleiro;
	
	public Estado(Tabuleiro aTabuleiro) {
		this.tabuleiro = aTabuleiro;
	}
	
	public boolean verificaObjetivo() {
		return this.tabuleiro.verificaObjetivo();
	}
	
	public Collection<Estado> geraFilhos() {
		Collection<Estado> filhos = new ArrayList<>();
		
		Coordenada coord = this.tabuleiro.getProximaVazia();
		
		for(int numero = 1; numero <= 9; numero++) {
			Tabuleiro copy = this.tabuleiro.deepCopy();
			if(copy.verificaCelulaValida(coord.i, coord.j, numero)) {
				copy.setCell(coord.i, coord.j, numero);
				filhos.add(new Estado(copy));
			}
		}
		return filhos;
		
	}
	
	@Override
	public String toString() {
		String res = "\nEstado: \n";
		res += this.tabuleiro.toString();
		res += "\n";
		return res;
	}

}
