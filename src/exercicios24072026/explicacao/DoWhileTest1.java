package exercicios24072026.explicacao;

import java.util.Scanner;

public class DoWhileTest1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int numero;

		do {
			System.out.print("Digite um número (0 para sair): ");
			numero = scanner.nextInt();

			System.out.println("Você digitou: " + numero);

		} while (numero != 0);

		System.out.println("Programa encerrado!");

		scanner.close();
	}
}