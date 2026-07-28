package exercicios.antecipado.arrayvetores;

import java.util.Scanner;

public class Exercicio04Vetor {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String[] clientes = new String[5];
		int[] dvdsLocados = new int[5];

		for (int i = 0; i < clientes.length; i++) {

			System.out.print("Digite o nome do cliente " + (i + 1) + ": ");
			clientes[i] = scanner.nextLine();

			System.out.print("Quantidade de DVDs locados em 2022: ");
			dvdsLocados[i] = scanner.nextInt();

			scanner.nextLine();
		}

		System.out.println("\nLOCAÇÕES GRÁTIS");

		for (int i = 0; i < clientes.length; i++) {

			int gratis = dvdsLocados[i] / 10;

			System.out.println("Cliente: " + clientes[i] + " | Locações grátis: " + gratis);
		}

		scanner.close();
	}
}