package exercicios24072026.explicacao;

import java.util.Scanner;

public class WhileTest1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int num;
		int soma = 0;

		System.out.println("Digite vários números (0 para sair):");

		System.out.print("Número: ");
		num = scanner.nextInt();

		while (num != 0) {
			soma += num;

			System.out.print("Número: ");
			num = scanner.nextInt();
		}

		System.out.println("Soma total = " + soma);

		scanner.close();
	}
}