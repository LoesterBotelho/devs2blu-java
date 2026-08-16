package exercicios15082026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class GestaoFrota {
	public static void main(String[] args) {
		List<Veiculo> frota = new ArrayList<>();

		frota.add(new Carro("ABC-1234", "Sedan", 100.0, 4));
		frota.add(new Caminhao("XYZ-9876", "Scania", 500.0, 10.0));

		System.out.println(" Relatório de Manutenção ");
		for (Veiculo v : frota) {

			System.out.println("Modelo: " + v.getModelo() + " | Custo: R$" + v.calcularCustoManutencao());

			if (v instanceof Tributavel) {
				Tributavel t = (Tributavel) v;
				System.out.println("-> Imposto Anual: R$" + t.calcularImpostoAnual());
			}
		}
	}
}