package exercicios02092026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		// Uso de Collections (Map e List) com Classes Wrapper (Integer e Double)
		Map<Integer, List<Double>> folhaPagamento = new HashMap<>();

		// Autoboxing convertendo valores primitivos em objetos Wrapper (Integer e Double)
		List<Double> bonusFunc1 = new ArrayList<>(List.of(150.0, 200.5));
		folhaPagamento.put(101, bonusFunc1);
		

		for (Map.Entry<Integer, List<Double>> entry : folhaPagamento.entrySet()) {
			Integer idFuncionario = entry.getKey();   // Wrapper Integer
			List<Double> bonus = entry.getValue();    // Collection com Wrapper Double

			System.out.println("Funcionário ID: " + idFuncionario + " | Bônus iniciais: " + bonus);

			// Chamada do método utilizando Wildcard com limite inferior (<? super Double>)
			ProcessadorSalarios.adicionarBonusExtra(bonus, 350.0);
			System.out.println("Bônus atualizados: " + bonus);

			// Chamada do método utilizando Wildcard irrestrito (<?> )
			ProcessadorSalarios.contarRegistros(bonus);
		}
	}
}