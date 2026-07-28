package exercicios.antecipado.lista5parte2;

import java.util.Scanner;

public class Exercicio10 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite um número: ");
		int x = scanner.nextInt();

		for (int i = 1; i <= 10; i++) {

			int resultado = x * i;

			System.out.println(x + " x " + i + " = " + resultado);

		}

		scanner.close();
	}
}