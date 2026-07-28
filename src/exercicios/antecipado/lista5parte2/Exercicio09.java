package exercicios.antecipado.lista5parte2;

import java.util.Scanner;

public class Exercicio09 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int codigo;
		int senha;

		do {

			System.out.print("Digite o código do usuário: ");
			codigo = scanner.nextInt();

			if (codigo <= 0) {
				System.out.println("Erro: o código deve ser um número positivo.");
			}

		} while (codigo <= 0);

		do {

			System.out.print("Digite a senha: ");
			senha = scanner.nextInt();

			if (senha <= 0) {
				System.out.println("Erro: a senha deve ser um número positivo.");
			}

			else if (senha == codigo) {
				System.out.println("Erro: a senha não pode ser igual ao código.");
			}

		} while (senha <= 0 || senha == codigo);

		System.out.println();
		System.out.println("Usuário cadastrado com sucesso!");
		System.out.println("Código: " + codigo);

		scanner.close();
	}
}