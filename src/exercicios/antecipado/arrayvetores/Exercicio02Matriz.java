package exercicios.antecipado.arrayvetores;

import java.util.Scanner;

public class Exercicio02Matriz {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("PESQUISA DE FILHOS");

		System.out.print("Digite a quantidade de pessoas entrevistadas: ");
		int quantidadePessoas = scanner.nextInt();

		scanner.nextLine();

		Filho[][] pessoas = new Filho[quantidadePessoas][];

		for (int i = 0; i < quantidadePessoas; i++) {

			System.out.println("\nPessoa " + (i + 1));

			System.out.print("Quantidade de filhos: ");
			int quantidadeFilhos = scanner.nextInt();

			scanner.nextLine();

			pessoas[i] = new Filho[quantidadeFilhos];

			for (int j = 0; j < quantidadeFilhos; j++) {

				System.out.println("\nFilho " + (j + 1));

				System.out.print("Nome: ");
				String nome = scanner.nextLine();

				System.out.print("Idade: ");
				int idade = scanner.nextInt();

				scanner.nextLine();

				pessoas[i][j] = new Filho(nome, idade);
			}
		}

		System.out.println("\nRESULTADO DA PESQUISA");
		System.out.println("Quantidade de pessoas entrevistadas: " + pessoas.length);

		for (int i = 0; i < pessoas.length; i++) {

			System.out.println("\nPessoa " + (i + 1));
			System.out.println("Quantidade de filhos: " + pessoas[i].length);

			if (pessoas[i].length == 0) {

				System.out.println("Não possui filhos.");

			} else {

				System.out.println("Filhos:");

				for (int j = 0; j < pessoas[i].length; j++) {

					System.out.println("- " + pessoas[i][j]);
				}
			}
		}

		scanner.close();
	}
}