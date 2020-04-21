package entity;

public class Coordenada {
	
	public double x;
	public double y;
	
	public Coordenada(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	
	
	

}
