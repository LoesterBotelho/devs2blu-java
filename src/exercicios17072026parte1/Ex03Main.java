package exercicios17072026parte1;

import java.util.Scanner;

public class Ex03Main {

	public static void main(String[] args) {
		
		getAuthor();
		double entrada = 0.0;
		
		Scanner sc = new Scanner(System.in);
				
		Ex03 ex03 = new Ex03();
		
		System.out.println("Digite o numero 1: ");
		entrada = sc.nextDouble();
		
		ex03.setValor01(entrada);
		
		System.out.println("Digite o numero 2: ");
		entrada = sc.nextDouble();
		
		ex03.setValor02(entrada);
		
		System.out.println("A soma dos valores : " + ex03.getSoma());
		System.out.println("A soma dos valores : " + ex03.getDobro());
		
		System.out.println(ex03.toString());
		
		sc.close();
		
	}
	
	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");	
		System.out.println("---------------------------------------------------\n");
	}
	
}
