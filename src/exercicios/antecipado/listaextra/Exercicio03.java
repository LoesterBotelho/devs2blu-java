package exercicios.antecipado.listaextra;

import java.util.Scanner;

public class Exercicio03 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite a idade do nadador: ");
		int idade = scanner.nextInt();

		if (idade >= 5 && idade <= 7) {

			System.out.println("Categoria Infantil A");

		} else if (idade <= 10) {

			System.out.println("Categoria Infantil B");

		} else if (idade <= 13) {

			System.out.println("Categoria Juvenil A");

		} else if (idade <= 17) {

			System.out.println("Categoria Juvenil B");

		} else if (idade >= 18) {

			System.out.println("Categoria Adulto");

		} else {

			System.out.println("Idade inválida");

		}

		scanner.close();

	}
}