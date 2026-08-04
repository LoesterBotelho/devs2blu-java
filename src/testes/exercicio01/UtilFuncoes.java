package testes.exercicio01;

import java.util.Arrays;

public class UtilFuncoes {

	public static void getMultiplosDeTresAteCemV1() {
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				System.out.println(i);
			}
		}
	}

	public static void getMultiplosDeTresAteCemV2() {
		for (int i = 3; i <= 100; i += 3) {
			System.out.println(i);
		}
	}

	public static void getNumeros200a300V1() {
		int i = 200;

		while (i <= 300) {
			System.out.println(i++);
		}
	}

	public static void getNumeros200a300V2() {
		for (int i = 200; i <= 300; i++) {
			System.out.println(i);
		}
	}

	public static void getSomaV1() {
		int soma = 0;
		int i = 1;

		while (i <= 1000) {
			soma += i;
			i++;
		}

		System.out.println("Soma = " + soma);
	}

	public static void getSomaV2() {
		int soma = 0;

		for (int i = 1; i <= 1000; i++) {
			soma += i;
		}

		System.out.println("Soma = " + soma);
	}

	public static void getGastosAno() {

		int[] gastos = { 12000, 15000, 17000, 18000, 16000, 19000, 20000, 21000, 18000, 22000, 24000, 30000 };

		int total = 0;

		for (int gasto : gastos) {
			total += gasto;
		}

		double media = total / (double) gastos.length;

		Arrays.sort(gastos);

		double mediana = (gastos[5] + gastos[6]) / 2.0;

		System.out.println("Total........: R$ " + total);
		System.out.printf("Média........: R$ %.2f%n", media);
		System.out.printf("Mediana......: R$ %.2f%n", mediana);
	}

	public static void getFatorial() {

		int fatorial = 1;

		for (int n = 1; n <= 10; n++) {
			fatorial *= n;
			System.out.println("fat(" + n + ") = " + fatorial);
		}
	}

	public static void getCelsius() {

		double fahrenheit = 86;
		double celsius = (fahrenheit - 32) / 1.8;

		System.out.printf("%.2f °C%n", celsius);
	}

	public static void getFahrenheit() {

		double celsius = 30;
		double fahrenheit = celsius * 1.8 + 32;

		System.out.printf("%.2f °F%n", fahrenheit);
	}

	public static void getVolumeCubo() {

		double lado = 4;
		double volume = Math.pow(lado, 3);

		System.out.println("Volume = " + volume);
	}

	public static void getAreaRetangulo() {

		double largura = 10;
		double altura = 8;

		System.out.println("Área = " + (largura * altura));
	}

	public static void getAreaCirculo() {

		double raio = 5;
		double area = Math.PI * raio * raio;

		System.out.printf("Área = %.2f%n", area);
	}

	public static void getJurosCompostos() {

		double capital = 1000;
		double taxa = 0.05;
		int meses = 12;

		double montante = capital * Math.pow(1 + taxa, meses);

		System.out.printf("Montante = R$ %.2f%n", montante);
	}

	public static void getJurosSimples() {

		double capital = 1000;
		double taxa = 5;
		int meses = 10;

		double juros = capital * taxa * meses / 100;

		System.out.printf("Juros = R$ %.2f%n", juros);
	}

	public static void getDesconto() {

		double preco = 2500;
		double desconto = 15;

		double valorFinal = preco * (1 - desconto / 100);

		System.out.printf("Valor com desconto = R$ %.2f%n", valorFinal);
	}

	public static void getRegraTres() {

		double percentual = 80;
		double valorPago = 800;

		double valorOriginal = valorPago * 100 / percentual;

		System.out.printf("Valor original = R$ %.2f%n", valorOriginal);
	}

	public static void getSituacaoAluno() {

		double media = 6.5;

		if (media >= 7) {
			System.out.println("Aprovado");
		} else {
			System.out.println("Reprovado");
		}
	}

	public static void getMaiorTresNumeros() {

		int a = 10;
		int b = 40;
		int c = 25;

		int maior = Math.max(a, Math.max(b, c));

		System.out.println("Maior = " + maior);
	}

	public static void getAnoBissexto() {

		int ano = 2026;

		if ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0) {
			System.out.println(ano + " é bissexto.");
		} else {
			System.out.println(ano + " não é bissexto.");
		}
	}
}