package exercicios17072026;

import java.util.Scanner;

public class Ex08Main {

	public static void main(String[] args) {

		getAuthor();

		Scanner sc = new Scanner(System.in);

		Ex08 ex08 = new Ex08();

		System.out.print("Informe a quantidade de horas: ");
		int entrada = sc.nextInt();

		ex08.setHoras(entrada);

		System.out.println(ex08.getHoras() + " hora(s) corresponde(m) a:");
		System.out.println(ex08.getMinutos() + " minuto(s).");
		System.out.println(ex08.getSegundos() + " segundo(s).");

		sc.close();
	}

	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");
		System.out.println("---------------------------------------------------\n");
	}

}