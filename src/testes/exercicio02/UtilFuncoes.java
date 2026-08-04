package testes.exercicio02;

import java.util.Arrays;

public class UtilFuncoes {

	public static void getIMC() {

		double peso = 82.5;
		double altura = 1.78;

		double imc = peso / (altura * altura);

		System.out.printf("IMC = %.2f%n", imc);

		if (imc < 18.5) {
			System.out.println("Abaixo do peso");
		} else if (imc < 25) {
			System.out.println("Peso normal");
		} else if (imc < 30) {
			System.out.println("Sobrepeso");
		} else {
			System.out.println("Obesidade");
		}
	}

	public static void getPrestacaoFinanciamento() {

		double valor = 250000;
		double taxa = 0.0095;
		int parcelas = 360;

		double prestacao = valor * (taxa * Math.pow(1 + taxa, parcelas)) / (Math.pow(1 + taxa, parcelas) - 1);

		System.out.printf("Prestação = R$ %.2f%n", prestacao);
	}

	public static void getMediaPonderada() {

		double[] notas = { 8.5, 6.0, 9.5 };
		double[] pesos = { 2, 3, 5 };

		double somaNotas = 0;
		double somaPesos = 0;

		for (int i = 0; i < notas.length; i++) {
			somaNotas += notas[i] * pesos[i];
			somaPesos += pesos[i];
		}

		System.out.printf("Média = %.2f%n", somaNotas / somaPesos);
	}

	public static void getDesvioPadrao() {

		double[] valores = { 10, 12, 8, 15, 20 };

		double media = Arrays.stream(valores).average().orElse(0);

		double soma = 0;

		for (double valor : valores) {
			soma += Math.pow(valor - media, 2);
		}

		double desvio = Math.sqrt(soma / valores.length);

		System.out.printf("Desvio padrão = %.2f%n", desvio);
	}

	public static void getNumeroPrimo() {

		int numero = 97;

		boolean primo = true;

		if (numero <= 1) {
			primo = false;
		} else {

			for (int i = 2; i <= Math.sqrt(numero); i++) {

				if (numero % i == 0) {
					primo = false;
					break;
				}

			}

		}

		System.out.println(primo ? "Primo" : "Não primo");
	}

	public static void getMMC() {

		int a = 18;
		int b = 24;

		int maior = Math.max(a, b);
		int mmc = maior;

		while (true) {

			if (mmc % a == 0 && mmc % b == 0) {
				break;
			}

			mmc++;
		}

		System.out.println("MMC = " + mmc);
	}

	public static void getMDC() {

		int a = 48;
		int b = 18;

		while (b != 0) {

			int resto = a % b;
			a = b;
			b = resto;

		}

		System.out.println("MDC = " + a);
	}

	public static void getDistanciaEntreDoisPontos() {

		double x1 = 2;
		double y1 = 3;

		double x2 = 8;
		double y2 = 11;

		double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

		System.out.printf("Distância = %.2f%n", distancia);
	}

	public static void getEquacaoSegundoGrau() {

		double a = 2;
		double b = 5;
		double c = -3;

		double delta = Math.pow(b, 2) - (4 * a * c);

		if (delta < 0) {
			System.out.println("Sem raízes reais");
			return;
		}

		double x1 = (-b + Math.sqrt(delta)) / (2 * a);
		double x2 = (-b - Math.sqrt(delta)) / (2 * a);

		System.out.printf("x1 = %.2f%n", x1);
		System.out.printf("x2 = %.2f%n", x2);
	}

	public static void getValorPresenteLiquido() {

		double investimento = 50000;
		double taxa = 0.10;

		double[] fluxos = { 12000, 15000, 18000, 22000, 25000 };

		double vpl = -investimento;

		for (int i = 0; i < fluxos.length; i++) {
			vpl += fluxos[i] / Math.pow(1 + taxa, i + 1);
		}

		System.out.printf("VPL = %.2f%n", vpl);
	}

	public static void getCoeficienteVariacao() {

		double[] dados = { 15, 18, 20, 22, 17 };

		double media = Arrays.stream(dados).average().orElse(0);

		double soma = 0;

		for (double valor : dados) {
			soma += Math.pow(valor - media, 2);
		}

		double desvio = Math.sqrt(soma / dados.length);

		double cv = (desvio / media) * 100;

		System.out.printf("CV = %.2f%%%n", cv);
	}

	public static void getConsumoCombustivel() {

		double distancia = 845.5;
		double litros = 61.8;

		double consumo = distancia / litros;

		System.out.printf("Consumo = %.2f km/L%n", consumo);
	}

	public static void getSalarioLiquido() {

		double salario = 8500;

		double inss = salario * 0.11;
		double imposto = salario * 0.15;

		double liquido = salario - inss - imposto;

		System.out.printf("Salário líquido = R$ %.2f%n", liquido);
	}

	public static void getValorHoraTrabalhada() {

		double salario = 4500;
		int horas = 220;

		System.out.printf("Valor hora = R$ %.2f%n", salario / horas);
	}

	public static void getCrescimentoPopulacional() {

		double populacao = 150000;
		double crescimento = 0.021;

		int anos = 15;

		double futura = populacao * Math.pow(1 + crescimento, anos);

		System.out.printf("População futura = %.0f habitantes%n", futura);
	}

}