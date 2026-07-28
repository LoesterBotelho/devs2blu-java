package exercicios.antecipado.arrayvetores;

import java.util.Scanner;

public class Exercicio03Vetor {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int[] A = new int[10];

		int somaMenores = 0;
		int quantidadeIgual = 0;

		int somaMaiores = 0;
		int quantidadeMaiores = 0;

		for (int i = 0; i < A.length; i++) {

			System.out.print("Digite o valor da posição " + i + ": ");
			A[i] = scanner.nextInt();
		}

		for (int i = 0; i < A.length; i++) {

			if (A[i] < 15) {

				somaMenores += A[i];

			} else if (A[i] == 15) {

				quantidadeIgual++;

			} else {

				somaMaiores += A[i];
				quantidadeMaiores++;
			}
		}

		System.out.println();
		System.out.println("Soma dos elementos menores que 15: " + somaMenores);
		System.out.println("Quantidade de elementos iguais a 15: " + quantidadeIgual);

		if (quantidadeMaiores > 0) {

			double media = (double) somaMaiores / quantidadeMaiores;

			System.out.println("Média dos elementos maiores que 15: " + media);

		} else {
			System.out.println("Não existem elementos maiores que 15.");
		}

		scanner.close();
	}
}