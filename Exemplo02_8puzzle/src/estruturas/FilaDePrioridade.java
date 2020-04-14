package estruturas;

import java.util.Comparator;
import java.util.PriorityQueue;

import entity.Estado;
import solver.HeuriticasDeAvaliacao;

public class FilaDePrioridade implements EstruturaDeEstadosAbertos {
	
	PriorityQueue<Estado> f = new PriorityQueue<>(
			new Comparator<Estado>() {
				@Override
				public int compare(Estado e1, Estado e2) {
					int res1 = HeuriticasDeAvaliacao.pecasForaDoLugar(e1);
					res1+=e1.getNivel();
					int res2 = HeuriticasDeAvaliacao.pecasForaDoLugar(e2);
					res2+=e2.getNivel();
					int result = Integer.compare(res1, res2);
					return result;
				}
			});

	
	@Override
	public Estado pop() {
		return f.poll();
	}

	@Override
	public void push(Estado e) {
		f.add(e);
	}

	@Override
	public int size() {
		return f.size();
	}
	
	

}
