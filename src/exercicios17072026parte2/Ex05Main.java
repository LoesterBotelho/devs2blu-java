package exercicios17072026parte2;

import java.util.Scanner;

public class Ex05Main {
	
	public static void main(String[] args) {
		
		getAuthor();
		
		Scanner sc = new Scanner(System.in);	

        System.out.print("Digite o valor de a: ");
        double a = sc.nextDouble();

        System.out.print("Digite o valor de b: ");
        double b = sc.nextDouble();

        System.out.print("Digite o valor de c: ");
        double c = sc.nextDouble();

        System.out.print("Digite o valor de d: ");
        double d = sc.nextDouble();

        System.out.print("Digite o valor de e: ");
        double e = sc.nextDouble();

        System.out.print("Digite o valor de f: ");
        double f = sc.nextDouble();

		Ex05 ex05 = new Ex05(a, b, c, d, e, f);
		
		System.out.println("Valor X ................: " + ex05.getX());
		System.out.println("Valor Y ................: " + ex05.getY());
		System.out.println("Valor Denominador.......: " + ex05.getDenominador());
				
		System.out.println("\n" + ex05.toString());
		
		sc.close();
	}
		
	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");	
		System.out.println("---------------------------------------------------\n");
	}
	
}
