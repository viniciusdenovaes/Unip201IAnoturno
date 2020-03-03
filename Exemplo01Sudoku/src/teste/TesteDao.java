package teste;

import dao.Dao;

public class TesteDao {
	
	public static void main(String[] args) {
		Dao dao = new Dao("instances/s10a.txt");
		dao.getInstance();
	}

}
