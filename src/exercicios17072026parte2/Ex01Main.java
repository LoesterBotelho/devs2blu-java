package exercicios17072026parte2;

import java.util.Scanner;

public class Ex01Main {
	
	public static void main(String[] args) {
		
		getAuthor();
		
		Scanner sc = new Scanner(System.in);	
		double entrada = 0.0;
		
		Ex01 ex01 = new Ex01();
		
		System.out.println("Digite Cateto A : ");
		entrada = sc.nextDouble();
		
		ex01.setCatetoA(entrada);
			
		
		System.out.println("Digite Cateto B : ");
		entrada = sc.nextDouble();
		
		ex01.setCatetoB(entrada);		
				
		System.out.println("Valor Hipotenusa : " + ex01.getHipotenusa());
		
		System.out.println("\n" + ex01.toString());
		
		sc.close();
	}
		
	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");	
		System.out.println("---------------------------------------------------\n");
	}
	
}
