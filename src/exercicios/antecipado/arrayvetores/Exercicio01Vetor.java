package exercicios.antecipado.arrayvetores;

import java.util.Scanner;

public class Exercicio01Vetor {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int[] A = new int[10];

		int somaImpares = 0;
		int quantidadeImpares = 0;

		for (int i = 0; i < A.length; i++) {
			System.out.print("Digite o valor da posição " + i + ": ");
			A[i] = scanner.nextInt();
		}

		for (int i = 0; i < A.length; i++) {

			if (A[i] % 2 != 0) {
				somaImpares += A[i];
				quantidadeImpares++;
			}
		}

		if (quantidadeImpares > 0) {

			double media = (double) somaImpares / quantidadeImpares;

			System.out.println("\nSoma dos ímpares: " + somaImpares);
			System.out.println("Quantidade de ímpares: " + quantidadeImpares);
			System.out.println("Média dos ímpares: " + media);

		} else {
			System.out.println("Não existem números ímpares no vetor.");
		}

		scanner.close();
	}
}