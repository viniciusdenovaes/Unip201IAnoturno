package entity;

public class Vertice implements Comparable<Vertice>{
	
	private String nome;
	
	public Vertice(String aNome) {
		this.nome = aNome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	@Override
	public int compareTo(Vertice o) {
		return this.getNome().compareTo(o.getNome());
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertice other = (Vertice) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "vertice " + nome;
	}

	
	

}
