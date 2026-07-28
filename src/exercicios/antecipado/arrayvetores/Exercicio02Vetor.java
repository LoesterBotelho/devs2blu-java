package exercicios.antecipado.arrayvetores;

import java.util.Scanner;

public class Exercicio02Vetor {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int[] A = new int[10];

		int quantidade = 0;

		for (int i = 0; i < A.length; i++) {

			System.out.print("Digite a idade da pessoa " + (i + 1) + ": ");
			A[i] = scanner.nextInt();
		}

		for (int i = 0; i < A.length; i++) {

			if (A[i] > 35) {
				quantidade++;
			}
		}

		System.out.println();
		System.out.println("Quantidade de pessoas com idade superior a 35 anos: " + quantidade);

		scanner.close();
	}
}