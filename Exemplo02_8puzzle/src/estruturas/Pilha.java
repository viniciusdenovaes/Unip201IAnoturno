package estruturas;

import java.util.Stack;

import entity.Estado;

public class Pilha implements EstruturaDeEstadosAbertos{
	
	Stack<Estado> elementos = new Stack<>();

	@Override
	public Estado pop() {
		return elementos.pop();
	}

	@Override
	public void push(Estado e) {
		elementos.push(e);
	}

	@Override
	public int size() {
		return elementos.size();
	}
	
	

}
