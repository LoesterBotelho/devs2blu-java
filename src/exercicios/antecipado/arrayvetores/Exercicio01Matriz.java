package exercicios.antecipado.arrayvetores;

import java.util.Scanner;

public class Exercicio01Matriz {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("PESQUISA DE QUANTIDADE DE FILHOS");

		System.out.print("Digite a quantidade de pessoas entrevistadas: ");
		int quantidadePessoas = scanner.nextInt();

		scanner.nextLine();

		String[][] filhos = new String[quantidadePessoas][];

		for (int i = 0; i < quantidadePessoas; i++) {

			System.out.println("\nPessoa " + (i + 1));

			System.out.print("Quantidade de filhos: ");
			int quantidadeFilhos = scanner.nextInt();

			scanner.nextLine();

			filhos[i] = new String[quantidadeFilhos];

			for (int j = 0; j < quantidadeFilhos; j++) {

				System.out.print("Nome do filho " + (j + 1) + ": ");
				filhos[i][j] = scanner.nextLine();
			}
		}

		System.out.println("\nRESULTADO DA PESQUISA");

		System.out.println("Quantidade de pessoas entrevistadas: " + filhos.length);

		for (int i = 0; i < filhos.length; i++) {

			System.out.println("\nPessoa " + (i + 1));

			System.out.println("Quantidade de filhos: " + filhos[i].length);

			if (filhos[i].length == 0) {

				System.out.println("Não possui filhos.");

			} else {

				System.out.println("Filhos:");

				for (int j = 0; j < filhos[i].length; j++) {

					System.out.println("- " + filhos[i][j]);
				}
			}
		}

		scanner.close();
	}
}