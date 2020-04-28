package entity;

public class Vertice implements Comparable<Vertice>{
	
	private int id;
	private String nome;
	private Coordenada coord;
	
	public Vertice(int aId, String aNome, Coordenada aCoord) {
		this.id = aId;
		this.nome = aNome;
		this.coord = aCoord;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Coordenada getCorrdenada() {
		return this.coord;
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
		return "vertice("+id+") " + nome + " (" + coord.x + ", " + coord.y + ")";
	}

	
	

}
