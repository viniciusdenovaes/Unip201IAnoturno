package teste;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class TesteStructs {
	
	public static void main(String[] args) {
		testeStack();
		testeQueue();
	}
	
	static void testeStack() {
		System.out.println("Testando pilha");
		Stack<Integer> pilha = new Stack<>();
		pilha.push(1);
		pilha.push(2);
		pilha.push(3);
		pilha.push(4);
		pilha.push(5);
		for(Integer e : pilha) {
			System.out.println(e);
		}
		System.out.println(pilha.pop());
		System.out.println(pilha.pop());
		System.out.println(pilha.pop());
		System.out.println(pilha.pop());
		System.out.println(pilha.pop());
		
	}
	
	static void testeQueue() {
		System.out.println("Testando fila");
		Deque<Integer> fila = new LinkedList<>();
		fila.add(1);
		fila.add(2);
		fila.add(3);
		fila.add(4);
		fila.add(5);
		
		for(Integer e : fila) {
			System.out.println(e);
		}
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		
	}

}
