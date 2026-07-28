package exercicios.antecipado.listaextra;

import java.util.Scanner;

public class Exercicio01 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite um número: ");
		int numero = scanner.nextInt();

		if (numero > 0) {
			System.out.println("Número positivo");
		} else if (numero < 0) {
			System.out.println("Número negativo");
		} else {
			System.out.println("Número neutro");
		}

		scanner.close();
	}
}