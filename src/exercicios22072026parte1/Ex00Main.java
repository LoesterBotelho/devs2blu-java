package exercicios22072026parte1;

import java.util.Scanner;

public class Ex00Main {

	public static void main(String[] args) {

		getAuthor();

		Scanner sc = new Scanner(System.in);
		int entrada = 0;

		Ex00 ex00 = new Ex00();

		System.out.println("Digite o dia da semana em inteiro 1-7 : ");
		entrada = sc.nextInt();

		ex00.setDiaSemana(entrada);

		System.out.println("\n" + ex00.getDiaSemana());
		
		System.out.println("\n" + ex00.toString());

		sc.close();
	}

	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");
		System.out.println("---------------------------------------------------\n");
	}

}
