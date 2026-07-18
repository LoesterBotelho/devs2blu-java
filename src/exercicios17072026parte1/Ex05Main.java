package exercicios17072026parte1;

import java.util.Scanner;

public class Ex05Main {

	public static void main(String[] args) {
		getAuthor();
		
		Scanner sc = new Scanner(System.in);
		
		Ex05 ex05 = new Ex05();
		
		System.out.println("Digite quantidade de minutos em consumo : ");
		int entrada = sc.nextInt();		
		
		ex05.setTotalMinutos(entrada);
		
		System.out.println("Preco total a pagar : " + ex05.getPrecoTotal());
		
		System.out.println(ex05.toString());
		
		sc.close();
	}
	
	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");	
		System.out.println("---------------------------------------------------\n");
	}
	
}
