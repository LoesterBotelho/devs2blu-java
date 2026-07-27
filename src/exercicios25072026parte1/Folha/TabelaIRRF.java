package exercicios25072026parte1.Folha;

import java.util.ArrayList;
import java.util.List;

public class TabelaIRRF {

	private List<Double> faixas = new ArrayList<>();

	public TabelaIRRF() {

		faixas.add(2259.20);
		faixas.add(2826.65);
		faixas.add(3751.05);
		faixas.add(4664.68);

	}

	public double calcularIRRF(double baseCalculo) {

		double imposto;

		if (baseCalculo <= faixas.get(0)) {

			imposto = 0;

		}

		else if (baseCalculo <= faixas.get(1)) {

			imposto = baseCalculo * 0.075;

		}

		else if (baseCalculo <= faixas.get(2)) {

			imposto = baseCalculo * 0.15;

		}

		else if (baseCalculo <= faixas.get(3)) {

			imposto = baseCalculo * 0.225;

		}

		else {

			imposto = baseCalculo * 0.275;

		}

		return imposto;

	}

	public void imprimirTabela() {

		System.out.println("Tabela IRRF");

		for (Double faixa : faixas) {

			System.out.println("Até R$ " + faixa);

		}

	}

}