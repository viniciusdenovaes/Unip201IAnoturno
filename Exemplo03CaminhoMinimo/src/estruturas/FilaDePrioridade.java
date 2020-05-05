package estruturas;

import java.util.Comparator;
import java.util.PriorityQueue;

import entity.Estado;
import solver.HeuristicasDeAvaliacao;

public class FilaDePrioridade implements EstruturaDeEstadosAbertos {
	
	PriorityQueue<Estado> f = new PriorityQueue<>(
			new Comparator<Estado>() {
				@Override
				public int compare(Estado e1, Estado e2) {
					double res1 = HeuristicasDeAvaliacao.f(e1);
					double res2 = HeuristicasDeAvaliacao.f(e2);
					int result = Double.compare(res1, res2);
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
