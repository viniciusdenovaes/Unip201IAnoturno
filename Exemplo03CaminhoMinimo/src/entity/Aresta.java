package entity;

public class Aresta {
	
	private double valor;
	private Vertice vertice;
	
	public Aresta(double aValor, Vertice aVertice) {
		this.valor = aValor;
		this.vertice = aVertice;
	}

	public double getValor() {
		return valor;
	}

	public Vertice getVertice() {
		return vertice;
	}

	@Override
	public String toString() {
		return "Aresta [valor=" + valor + ", vertice=" + vertice + "]";
	}
	
	

}
