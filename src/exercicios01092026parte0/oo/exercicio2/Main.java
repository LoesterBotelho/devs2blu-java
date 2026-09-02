package exercicios01092026parte0.oo.exercicio2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		
		// 1. Collections e Classes Wrapper (Long, Integer, Double)
		Map<Long, Integer> estoqueQuantidades = new HashMap<>();
		Map<Long, Double> precosUnitarios = new HashMap<>();

		// Populando os mapas usando Autoboxing (literais primitivos convertidos para Long, Integer e Double)
		estoqueQuantidades.put(78910111201L, 12);    // SKU -> Quantidade
		estoqueQuantidades.put(78910111202L, 3);     // Estoque crítico (< 5)
		estoqueQuantidades.put(78910111203L, 25);
		estoqueQuantidades.put(78910111204L, 2);     // Estoque crítico (< 5)

		precosUnitarios.put(78910111201L, 150.50);   // SKU -> Preço Unitário
		precosUnitarios.put(78910111202L, 2999.99);
		precosUnitarios.put(78910111203L, 45.00);
		precosUnitarios.put(78910111204L, 1200.00);

		System.out.println("Produtos cadastrados com sucesso.\n");

		// 2. Utilizando Generics com a classe FiltroEstoque para encontrar itens críticos (quantidade < 5)
		FiltroEstoque<Integer> filtroQuantidades = new FiltroEstoque<>(estoqueQuantidades);
		Set<Long> skusCriticos = filtroQuantidades.filtrarCriticos(5.0);

		System.out.println("SKUs com Estoque Crítico (< 5 unidades): " + skusCriticos);
		System.out.println();

		// 3. Desafio Adicional: Calcular o valor total financeiro investido no estoque
		double valorTotalEstoque = 0.0;

		System.out.println("--- Detalhamento do Inventário ---");
		
		for (Map.Entry<Long, Integer> entry : estoqueQuantidades.entrySet()) {
			
			Long sku = entry.getKey();                    // Wrapper Long
			Integer qtd = entry.getValue();               // Wrapper Integer
			Double preco = precosUnitarios.get(sku);      // Wrapper Double

			if (preco != null) {
				// Unboxing implícito de Integer e Double para tipos primitivos (int e double) fazendo a operação matemática
				
				double subtotal = qtd * preco;
				
				valorTotalEstoque += subtotal;

				System.out.printf("SKU: %d | Qtd: %d | Preço Unit.: R$ %.2f | Subtotal: R$ %.2f\n", 
						sku, 
						qtd, 
						preco,
						subtotal);
			}
		}

		System.out.println("--------------------------------------------------");
		System.out.printf("VALOR TOTAL INVESTIDO NO ESTOQUE: R$ %.2f\n", valorTotalEstoque);
	}
}