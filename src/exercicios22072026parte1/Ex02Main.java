package exercicios22072026parte1;

import java.util.Scanner;

public class Ex02Main {
	public static void main(String[] args) {
		
		getAuthor();
		
		Scanner sc = new Scanner(System.in);	
		int entrada = 0;
		
		Ex02 ex02 = new Ex02();
		
		System.out.println("Digite a idade para classificar : ");
		entrada = sc.nextInt();
		
		ex02.setIdade(entrada);
				
		System.out.println("Para idade : " + ex02.getIdade() + " - Classificação : " + ex02.getClassificacao());
		
		System.out.println("\n" + ex02.toString());
		
		sc.close();
	}
		
	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");	
		System.out.println("---------------------------------------------------\n");
	}
	
}