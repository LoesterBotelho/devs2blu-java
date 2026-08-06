package exercicios05082026parte0.oo.exemplo1;

public class Calculadora {

	public int somar(int a, int b) {
		return a + b;
	}

	public int somar(int a, int b, int c) {
		return a + b + c;
	}

	public long somar(long a, long b) {
		return a + b;
	}

	public long somar(long a, long b, long c) {
		return a + b + c;
	}
	
	public float somar(float a, float b) {
		return a + b;
	}

	public float somar(float a, float b, float c) {
		return a + b + c;
	}

	public double somar(double a, double b) {
		return a + b;
	}

	public double somar(double a, double b, double c) {
		return a + b + c;
	}

	public int somar(int[] numeros) {
		int soma = 0;

		for (int numero : numeros) {
			soma += numero;
		}

		return soma;
	}
}