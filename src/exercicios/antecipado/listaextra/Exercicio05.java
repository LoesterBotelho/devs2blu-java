package exercicios.antecipado.listaextra;

import java.util.Scanner;

public class Exercicio05 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("1 - Gasolina R$ 2,53");
		System.out.println("2 - Etanol R$ 2,09");
		System.out.println("3 - Diesel R$ 1,92");

		System.out.print("Escolha combustível: ");
		int opcao = scanner.nextInt();

		System.out.print("Quantidade de litros: ");
		double litros = scanner.nextDouble();

		double valorLitro = 0;
		String combustivel = "";

		switch (opcao) {

		case 1:
			valorLitro = 2.53;
			combustivel = "Gasolina";
			break;

		case 2:
			valorLitro = 2.09;
			combustivel = "Etanol";
			break;

		case 3:
			valorLitro = 1.92;
			combustivel = "Diesel";
			break;

		default:
			System.out.println("Opção inválida");
			scanner.close();
			return;
		}

		double total = litros * valorLitro;

		System.out.println("Combustível: " + combustivel);
		System.out.println("Total: R$ " + total);

		if (opcao == 2 && litros > 30) {

			System.out.println("Cliente ganhou troca de óleo!");

		} else {

			System.out.println("Sem direito a troca de óleo");

		}

		scanner.close();

	}
}