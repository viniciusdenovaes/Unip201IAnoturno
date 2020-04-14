package entity;

import java.util.ArrayList;
import java.util.List;

import solver.HeuriticasDeAvaliacao;

public class Estado {
	
	private Tabuleiro tabuleiro;
	private List<Acao> acoes;
	private int nivel;
	
	public Estado(Tabuleiro aTabuleiro) {
		this.tabuleiro = aTabuleiro;
		acoes = new ArrayList<>();
		nivel = 0;
	}
	
	public int get(int i, int j) {
		return this.tabuleiro.get(i, j);
	}
	
	public boolean isObjetivo() {
		if(tabuleiro.get(1, 1)!=0)return false;
		if(tabuleiro.get(0, 0)!=1)return false;
		if(tabuleiro.get(0, 1)!=2)return false;
		if(tabuleiro.get(0, 2)!=3)return false;
		if(tabuleiro.get(1, 2)!=4)return false;
		if(tabuleiro.get(2, 2)!=5)return false;
		if(tabuleiro.get(2, 1)!=6)return false;
		if(tabuleiro.get(2, 0)!=7)return false;
		if(tabuleiro.get(1, 0)!=8)return false;
		return true;
	}
	
	public void aplicarAcao(Acao acao) {
		
		addAcaoAoCaminho(acao);
		
		nivel++;
		
		Coordenada p0 = this.tabuleiro.posicaoDoZero();
		int i = p0.i;
		int j = p0.j;
		if(acao == Acao.CIMA) {
			this.tabuleiro.set(i, j, this.tabuleiro.get(i-1, j)); 
			this.tabuleiro.set(i-1, j, 0); 
		}
		if(acao == Acao.BAIXO) {
			this.tabuleiro.set(i, j, this.tabuleiro.get(i+1, j)); 
			this.tabuleiro.set(i+1, j, 0); 
		}
		if(acao == Acao.ESQUERDA) {
			this.tabuleiro.set(i, j, this.tabuleiro.get(i, j-1)); 
			this.tabuleiro.set(i, j-1, 0); 
		}
		if(acao == Acao.DIREITA) {
			this.tabuleiro.set(i, j, this.tabuleiro.get(i, j+1)); 
			this.tabuleiro.set(i, j+1, 0); 
		}
	}
	
	public boolean isAcaoPossivel(Acao acao) {
		Coordenada p0 = this.tabuleiro.posicaoDoZero();
		int i = p0.i;
		int j = p0.j;
		if(i==0             && acao==Acao.CIMA)     return false;
		if(i==Tabuleiro.N-1 && acao==Acao.BAIXO)    return false;
		if(j==0             && acao==Acao.ESQUERDA) return false;
		if(j==Tabuleiro.N-1 && acao==Acao.DIREITA)  return false;
		return true;
	}
	
	public List<Estado> geraFilhos(){
		List<Estado> filhos = new ArrayList<Estado>();
		for(Acao acao: Acao.values()) {
			if(!isAcaoPossivel(acao)) continue;
			Estado filho = this.deepCopy();
			filho.aplicarAcao(acao);
			filhos.add(filho);
		}
		return filhos;
	}
	
	private void addAcaoAoCaminho(Acao acao) {
		this.acoes.add(acao);
	}
	
	public int getNivel() {
		return nivel;
	}
	
	
	
	public Estado deepCopy() {
		Estado novo = new Estado(this.tabuleiro.deepCopy());
		for(Acao acao: acoes) {
			novo.acoes.add(acao);
		}
		novo.nivel = this.nivel;
		return novo;
	}
	
	@Override
	public String toString() {
		String res = "";
		res += "Estado (nivel " + this.nivel + "): \n";
		res += this.tabuleiro;
		res += "Caminho de Acoes ate este estado: ";
		for(Acao acao: this.acoes) {
			res += acao + ", ";
		}
		res += ".\n";
		res += "Heuristacas de avaliacao: \n";
		res += "\t pecasForaDoLugar: " 
				+ HeuriticasDeAvaliacao.pecasForaDoLugar(this);
				
				
		return res;
	}

}
