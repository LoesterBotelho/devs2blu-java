package exercicios30072026parte0;

public class Calculadora {

	Calculadora() {
	}

	public double soma(double numero1, double numero2) {
		return numero1 + numero2;
	}

	public float soma(float numero1, float numero2) {
		return numero1 + numero2;
	}

	public int soma(int numero1, int numero2) {
		return numero1 + numero2;
	}

	public long soma(long numero1, long numero2) {
		return numero1 + numero2;
	}

	public double soma(double valores[]) {
		double soma = 0;

		for (var i = 0; i <= valores.length - 1; i++) {
			soma += valores[i];
		}

		return soma;
	}

	public float soma(float valores[]) {
		float soma = 0;

		for (var i = 0; i <= valores.length - 1; i++) {
			soma += valores[i];
		}

		return soma;
	}

	public int soma(int valores[]) {
		int soma = 0;

		for (var i = 0; i <= valores.length - 1; i++) {
			soma += valores[i];
		}

		return soma;
	}

	public long soma(long valores[]) {
		long soma = 0;

		for (var i = 0; i <= valores.length - 1; i++) {
			soma += valores[i];
		}

		return soma;
	}

}
