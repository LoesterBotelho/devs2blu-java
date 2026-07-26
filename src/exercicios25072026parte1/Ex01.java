package exercicios25072026parte1;

import java.util.Arrays;

public class Ex01 {

	public double calcularMediaAritmetica(double n1, double n2, double n3, double n4) {
		return (n1 + n2 + n3 + n4) / 4.0;
	}

	public double calcularMediaPonderada(double n1, double n2, double n3, double n4) {
		return ((n1 * 1) + (n2 * 2) + (n3 * 3) + (n4 * 4)) / 10.0;
	}

	public double calcularMediana(double n1, double n2, double n3, double n4) {

		double[] notas = { n1, n2, n3, n4 };

		Arrays.sort(notas);

		return (notas[1] + notas[2]) / 2.0;
	}

	public double calcularNota100(double media) {
		return media * 10;
	}

	public String getConceito(double nota100) {

		if (nota100 >= 97)
			return "A+";
		else if (nota100 >= 93)
			return "A";
		else if (nota100 >= 87)
			return "B+";
		else if (nota100 >= 83)
			return "B";
		else if (nota100 >= 77)
			return "C+";
		else if (nota100 >= 73)
			return "C";
		else if (nota100 >= 67)
			return "D+";
		else if (nota100 >= 63)
			return "D";
		else if (nota100 >= 57)
			return "E+";
		else if (nota100 >= 50)
			return "E";
		else
			return "F";

	}

	public String getSituacao(double media) {

		if (media >= 7)
			return "Aprovado";
		else if (media >= 5)
			return "Recuperacao";
		else
			return "Reprovado";

	}

}