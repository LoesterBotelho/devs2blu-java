package exercicios17072026;

import java.util.Scanner;

public class Ex10Main {

	public static void main(String[] args) {

		getAuthor();

		Scanner sc = new Scanner(System.in);

		Ex10 ex10 = new Ex10();

		System.out.print("Digite o salário-base: R$ ");
		double entrada = sc.nextDouble();

		ex10.setSalarioBase(entrada);

		System.out.printf("Salário-base: R$ %.2f%n", ex10.getSalarioBase());
		System.out.printf("Gratificação (5%%): R$ %.2f%n", ex10.getGratificacao());
		System.out.printf("Imposto (7%%): R$ %.2f%n", ex10.getImposto());
		System.out.printf("Salário a receber: R$ %.2f%n",
				ex10.getSalarioReceber());

		sc.close();
	}

	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");
		System.out.println("---------------------------------------------------\n");
	}

}