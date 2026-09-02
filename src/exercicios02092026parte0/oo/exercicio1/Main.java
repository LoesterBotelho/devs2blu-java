package exercicios02092026parte0.oo.exercicio1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void imprimirDadosFrota(List<?> listaCargas) {
		System.out.println("Cargas cadastradas: " + listaCargas);
	}

	public static void main(String[] args) {

		// Usando Map e List (Collections) com Long e Double (Classes Wrapper)
		Map<Long, List<Double>> portfolio = new HashMap<>();

		portfolio.put(1001L, List.of(2.5, 4.1, 1.8));
		portfolio.put(1002L, List.of(-1.2, 3.5, 5.0));

		for (Map.Entry<Long, List<Double>> entry : portfolio.entrySet()) {
			Long idAtivo = entry.getKey();            // Wrapper Long
			List<Double> retornos = entry.getValue(); // Collection com Wrapper Double

			// Chamada do método utilizando Wildcard com limite superior
			double totalRetorno = AnalisadorFinanceiro.calcularSomaRetornos(retornos);
			System.out.printf("Ativo ID: %d | Soma dos Retornos: %.2f%%\n", idAtivo, totalRetorno);
		}
		
		System.out.println("\n------------------------------------------------------------------------\n");

		Map<Integer, List<Double>> frotas = new HashMap<>();

		// Autoboxing de int para Integer e double para Double
		frotas.put(501, List.of(12.5, 15.0, 10.2));
		frotas.put(502, List.of(8.0, 9.5));

		for (Map.Entry<Integer, List<Double>> entry : frotas.entrySet()) {
			Integer idFrota = entry.getKey();        // Wrapper Integer
			List<Double> cargas = entry.getValue();  // Collection com Wrapper Double

			System.out.print("Frota " + idFrota + " -> ");

			imprimirDadosFrota(cargas);
		}
	}
}