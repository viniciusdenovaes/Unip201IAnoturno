package solver;

import entity.Estado;

public class HeuriticasDeAvaliacao {
	
	public static int pecasForaDoLugar(Estado estado) {
		int foraLugar = 0;
		
		if(estado.get(0, 0)!=1) foraLugar++;
		if(estado.get(0, 1)!=2) foraLugar++;
		if(estado.get(0, 2)!=3) foraLugar++;
		if(estado.get(1, 2)!=4) foraLugar++;
		if(estado.get(2, 2)!=5) foraLugar++;
		if(estado.get(2, 1)!=6) foraLugar++;
		if(estado.get(2, 0)!=7) foraLugar++;
		if(estado.get(1, 0)!=8) foraLugar++;
		
		return foraLugar;
	}

}
