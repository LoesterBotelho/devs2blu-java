package exercicios17072026;

import java.util.Scanner;

public class Ex09Main {

	public static void main(String[] args) {

		getAuthor();

		Scanner sc = new Scanner(System.in);

		Ex09 ex09 = new Ex09();

		System.out.print("Digite o valor do produto: R$ ");
		double entrada = sc.nextDouble();

		ex09.setValorProduto(entrada);

		System.out.printf("Valor original: R$ %.2f%n", ex09.getValorProduto());
		System.out.printf("Valor com 9%% de desconto: R$ %.2f%n",
				ex09.getValorComDesconto());

		sc.close();
	}

	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");
		System.out.println("---------------------------------------------------\n");
	}

}