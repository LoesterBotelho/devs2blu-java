package exercicios17072026parte2;

import java.util.Scanner;

public class Ex02Main {
	
	public static void main(String[] args) {
		
		getAuthor();
		
		Scanner sc = new Scanner(System.in);	
		
		Ex02 ex02 = new Ex02();
		
		System.out.println("Digite o tamanho do lado do quadrado : ");
		double entrada = sc.nextDouble();
		
		ex02.setLadoQuadrado(entrada);
		System.out.println("Valor da area do quadrado ...........: " + ex02.getArea());
		System.out.println("Valor do perimetro do quadrado ......: " + ex02.getPerimetro());
		
		System.out.println("\n" + ex02.toString());
		
		sc.close();
	}
		
	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");	
		System.out.println("---------------------------------------------------\n");
	}
	
}
