package exercicios17072026parte1;

import java.util.Scanner;

public class Ex01Main {

	public static void main(String[] args) {
		
		getAuthor();
		
		Scanner sc = new Scanner(System.in);	
		
		Ex01 ex01 = new Ex01();
		
		System.out.println("Digite um valor para ser reajustado: ");
		double entrada = sc.nextDouble();
		
		ex01.setSaldo(entrada);
		System.out.println("Valor reajustado : " + ex01.getValorReajustado());
		
		System.out.println(ex01.toString());
		
		sc.close();
	}
	
	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");	
		System.out.println("---------------------------------------------------\n");
	}
}
