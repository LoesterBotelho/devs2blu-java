package exercicios.antecipado.listaextra;

import java.util.Scanner;

public class Exercicio02 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite sua altura: ");
		double altura = scanner.nextDouble();

		System.out.print("Digite seu sexo (M/F): ");
		char sexo = scanner.next().toUpperCase().charAt(0);

		double pesoIdeal;

		if (sexo == 'M') {

			pesoIdeal = (72.7 * altura) - 58;

			System.out.println("Peso ideal masculino: " + pesoIdeal + " kg");

		} else if (sexo == 'F') {

			pesoIdeal = (62.1 * altura) - 44.7;

			System.out.println("Peso ideal feminino: " + pesoIdeal + " kg");

		} else {

			System.out.println("Sexo inválido");

		}

		scanner.close();
	}
}