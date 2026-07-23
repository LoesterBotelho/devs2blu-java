package exercicios22072026parte1;

import java.util.Scanner;

public class Ex01Main {

	public static void main(String[] args) {
		
		getAuthor();
		
		Scanner sc = new Scanner(System.in);	
		int entrada = 0;
		
		Ex01 ex01 = new Ex01();
		
		System.out.println("Digite Valor Inteiro Positivo: ");
		entrada = sc.nextInt();
		
		ex01.setInteiroPositivo(entrada);
		
		System.out.println("Valor " + ex01.getInteiroPositivo() + " é " + ex01.getParImpar());
		
		System.out.println("\n" + ex01.toString());
		
		sc.close();
	}
		
	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");	
		System.out.println("---------------------------------------------------\n");
	}
	
}
