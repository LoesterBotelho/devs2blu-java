package exercicios.antecipado.lista5parte2;

import java.util.Scanner;

public class Exercicio08 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		char continuar;

		do {

			double populacaoA;
			double populacaoB;
			double taxaA;
			double taxaB;

			do {
				System.out.print("Informe a população do país A: ");
				populacaoA = scanner.nextDouble();

				if (populacaoA <= 0) {
					System.out.println("A população deve ser maior que zero.");
				}

			} while (populacaoA <= 0);

			do {
				System.out.print("Informe a população do país B: ");
				populacaoB = scanner.nextDouble();

				if (populacaoB <= 0) {
					System.out.println("A população deve ser maior que zero.");
				}

			} while (populacaoB <= 0);

			do {
				System.out.print("Informe a taxa de crescimento do país A (%): ");
				taxaA = scanner.nextDouble();

				if (taxaA <= 0) {
					System.out.println("A taxa deve ser maior que zero.");
				}

			} while (taxaA <= 0);

			do {
				System.out.print("Informe a taxa de crescimento do país B (%): ");
				taxaB = scanner.nextDouble();

				if (taxaB <= 0) {
					System.out.println("A taxa deve ser maior que zero.");
				}

			} while (taxaB <= 0);

			int anos = 0;

			while (populacaoA < populacaoB) {

				populacaoA += populacaoA * (taxaA / 100);
				populacaoB += populacaoB * (taxaB / 100);

				anos++;
			}

			System.out.println();
			System.out.println("Anos necessários: " + anos);
			System.out.printf("População final A: %.0f%n", populacaoA);
			System.out.printf("População final B: %.0f%n", populacaoB);

			System.out.print("\nDeseja realizar outro cálculo? (S/N): ");
			continuar = scanner.next().toUpperCase().charAt(0);

			System.out.println();

		} while (continuar == 'S');

		System.out.println("Programa encerrado.");

		scanner.close();
	}
}