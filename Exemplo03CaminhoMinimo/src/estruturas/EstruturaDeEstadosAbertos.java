package estruturas;

import entity.Estado;

public interface EstruturaDeEstadosAbertos {
	
	Estado pop();
	void push(Estado e);
	int size();

}
