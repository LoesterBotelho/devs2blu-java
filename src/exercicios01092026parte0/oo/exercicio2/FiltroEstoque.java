package exercicios01092026parte0.oo.exercicio2;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


class FiltroEstoque<T extends Number> {
	private Map<Long, T> itensEstoque;

	public FiltroEstoque(Map<Long, T> itensEstoque) {
		this.itensEstoque = itensEstoque;
	}

	// Método para filtrar chaves cujos valores numéricos sejam menores que o limite fornecido
	public Set<Long> filtrarCriticos(double limite) {
		
		Set<Long> criticos = new HashSet<>();
		
		for (Map.Entry<Long, T> entry : itensEstoque.entrySet()) {
			
			// Unboxing automático do Wrapper T para double através do método doubleValue()
			if (entry.getValue().doubleValue() < limite) {
				criticos.add(entry.getKey());
			}
			
		}
		
		return criticos;
	}

	// Método para exibir itens acima de determinado limite	
	public void exibirAcimaDe(double limite) {
		
		System.out.println("--- Itens com valor/quantidade acima de " + limite + " ---");
		
		
		for (Map.Entry<Long, T> entry : itensEstoque.entrySet()) {
			
			if (entry.getValue().doubleValue() > limite) {
				
				System.out.println("SKU: " + entry.getKey() + " | Valor: " + entry.getValue());
				
			}
			
		}
	}
}
