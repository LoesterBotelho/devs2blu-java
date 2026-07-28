package exercicios.antecipado.listaextra;

import java.util.Scanner;

public class Exercicio06 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Lado A: ");
		int a = scanner.nextInt();

		System.out.print("Lado B: ");
		int b = scanner.nextInt();

		System.out.print("Lado C: ");
		int c = scanner.nextInt();

		if (a + b > c && a + c > b && b + c > a) {

			if (a == b && b == c) {

				System.out.println("Triângulo equilátero");

			} else if (a == b || a == c || b == c) {

				System.out.println("Triângulo isósceles");

			} else {

				System.out.println("Triângulo escaleno");

			}

		} else {

			System.out.println("Não forma um triângulo");

		}

		scanner.close();

	}
}