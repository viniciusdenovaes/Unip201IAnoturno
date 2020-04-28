package estruturas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import entity.Estado;

public class Fila implements EstruturaDeEstadosAbertos{
	
	Queue<Estado> elementos = new LinkedList<>();

	@Override
	public Estado pop() {
		return elementos.poll();
	}

	@Override
	public void push(Estado e) {
		elementos.add(e);
	}

	@Override
	public int size() {
		return elementos.size();
	}
	
	

}
