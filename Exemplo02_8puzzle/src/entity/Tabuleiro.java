package entity;

public class Tabuleiro {
	
	public static final int N = 3;
	
	private int[][] tabuleiro = new int[N][N];
	
	public Tabuleiro() {
	}
	
	public Tabuleiro(int[][] aTabuleiro) {
		this();
		this.tabuleiro = aTabuleiro;
	}
	
	public int get(int i, int j) {
		return this.tabuleiro[i][j];
	}
	
	public void set(int i, int j, int valor) {
		this.tabuleiro[i][j] = valor;
	}
	
	public Coordenada posicaoDoZero() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(this.get(i, j)==0) {
					return new Coordenada(i, j);
				}
			}
		}
		return null;
	}
	
	public Tabuleiro deepCopy() {
		Tabuleiro novo = new Tabuleiro();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				novo.set(i, j, this.get(i, j));
			}
		}
		
		return novo;
	}
	
	@Override
	public String toString() {
		String res = "";
		res += "Tabuleiro: \n";
		for(int i=0; i<tabuleiro.length; i++) {
			for(int j=0; j<tabuleiro[i].length; j++) {
				res += tabuleiro[i][j] + " ";
			}
			res += "\n";
		}
				
		return res;
	}

}
