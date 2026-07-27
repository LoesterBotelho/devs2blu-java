package exercicios25072026parte1.Folha;

import java.util.ArrayList;
import java.util.List;

public class TabelaINSS {

	private List<Double> faixas = new ArrayList<>();

	public TabelaINSS() {

		faixas.add(1518.00);
		faixas.add(2793.88);
		faixas.add(4190.83);
		faixas.add(8157.41);

	}

	public double calcularINSS(double salario) {

		double valor = 0;

		if (salario <= faixas.get(0)) {

			valor = salario * 0.075;

		}

		else if (salario <= faixas.get(1)) {

			valor = salario * 0.09;

		}

		else if (salario <= faixas.get(2)) {

			valor = salario * 0.12;

		}

		else {

			valor = salario * 0.14;

		}

		return valor;

	}

	public void imprimirTabela() {

		System.out.println("Tabela INSS");

		for (Double faixa : faixas) {

			System.out.println("Até R$ " + faixa);

		}

	}

}