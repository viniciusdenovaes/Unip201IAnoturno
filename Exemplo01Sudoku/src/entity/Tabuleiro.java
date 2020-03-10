package entity;

import java.util.Set;
import java.util.TreeSet;

public class Tabuleiro {
	
	static final int N = 9;
	
	int[][] cells = new int[N][N];
	
	public Tabuleiro() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				this.cells[i][j] = 0;
			}
		}
	}
	
	public Tabuleiro(int[][] aCells) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				this.cells[i][j] = aCells[i][j];
			}
		}
	}
	
	public void setCell(int i, int j, int valor) {
		this.cells[i][j] = valor;
	}
	
	public int getCell(int i, int j) {
		return this.cells[i][j];
	}
	
	public boolean verificaLinha(int i) {
		Set<Integer> inseridos = new TreeSet<>();
		for(int j=0; j<N; j++) {
			if(this.cells[i][j] != 0) {
				if(inseridos.contains(this.cells[i][j])) {
					return false;
				}
				inseridos.add(this.cells[i][j]);
			}
		}
		return true;
	}
	
	public boolean verificaColuna(int j) {
		Set<Integer> inseridos = new TreeSet<>();
		for(int i=0; i<N; i++) {
			if(this.cells[i][j] != 0) {
				if(inseridos.contains(this.cells[i][j])) {
					return false;
				}
				inseridos.add(this.cells[i][j]);
			}
		}
		return true;
	}
	
	public boolean verificaQuadranteDaCelula(int r, int c) {
		int k = r/3;
		int l = c/3;
		Set<Integer> inseridos = new TreeSet<>();
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				int valor = this.cells[3*k+i][3*l+j]; 
				if(valor != 0) {
					if(inseridos.contains(valor)) {
						return false;
					}
					inseridos.add(valor);
				}
			}
		}
		return true;
		
	}
	
	public boolean verificaCelulaValida(int i, int j, int valor) {
		
		Tabuleiro copy = this.deepCopy();
		copy.setCell(i, j, valor);
		if(copy.verificaLinha(i)  == false) return false;
		if(copy.verificaColuna(j) == false) return false;
		if(copy.verificaQuadranteDaCelula(i, j) == false) return false;
		
		return true;
	}
	
	public boolean verificaObjetivo() {
		for(int i=0; i<Tabuleiro.N; i++) {
			for(int j=0; j<Tabuleiro.N; j++) {
				if(this.cells[i][j]==0) {
					return false;
				} 
			}
		}
		return true;
	}
	
	public Coordenada getProximaVazia() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(this.cells[i][j]==0) {
					return new Coordenada(i, j);
				}
			}
		}
		return null;
	}
	
	public Tabuleiro deepCopy() {
		Tabuleiro copy = new Tabuleiro(this.cells);
		return copy;
	}
	
	@Override
	public String toString() {
		String res = "";
		for(int i=0;i<N; i++) {
			res += " | ";
			for(int j=0;j<N; j++) {
				res += this.cells[i][j] + " | ";
			}
			if(i%3==2) {
				res += "\n";
				for(int l=0; l<35; l++) {
					res += "-";
				}
			}
			res += "\n";
		}
		return res;
	}
	
	static class Coordenada{
		int i;
		int j;
		
		public Coordenada(int aI, int aJ) {
			this.i = aI;
			this.j = aJ;
		}
		
		public String toString() {
			String res = "("+i+", "+j+")";
			return res;
		}
	}

}
