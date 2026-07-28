package exercicios.antecipado.listaextra;

import java.util.Scanner;

public class Exercicio07 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("1 - File Duplo");
		System.out.println("2 - Alcatra");
		System.out.println("3 - Picanha");

		System.out.print("Escolha a carne: ");
		int tipo = scanner.nextInt();

		System.out.print("Quantidade em KG: ");
		double kg = scanner.nextDouble();

		double precoKg = 0;
		String carne = "";

		switch (tipo) {

		case 1:

			carne = "File Duplo";

			if (kg < 5)
				precoKg = 4.90;
			else
				precoKg = 5.80;

			break;

		case 2:

			carne = "Alcatra";

			if (kg < 5)
				precoKg = 5.90;
			else
				precoKg = 6.80;

			break;

		case 3:

			carne = "Picanha";

			if (kg < 5)
				precoKg = 6.90;
			else
				precoKg = 7.80;

			break;

		default:

			System.out.println("Carne inválida");
			scanner.close();
			return;

		}

		double total = kg * precoKg;

		System.out.print("Pagamento cartão? (1-Sim / 2-Não): ");
		int cartao = scanner.nextInt();

		double desconto = 0;

		if (cartao == 1) {

			desconto = total * 0.05;

		}

		double totalFinal = total - desconto;

		System.out.println("\nCarne: " + carne);
		System.out.println("Quantidade: " + kg + " KG");
		System.out.println("Preço KG: R$ " + precoKg);
		System.out.println("Cálculo: " + kg + " x " + precoKg);
		System.out.println("Valor bruto: R$ " + total);

		if (desconto > 0) {

			System.out.println("Desconto: R$ " + desconto);

		}

		System.out.println("Total a pagar: R$ " + totalFinal);

		scanner.close();

	}
}