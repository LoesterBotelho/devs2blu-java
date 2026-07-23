package exercicios22072026parte1;

import java.util.Scanner;

public class Ex06Main {
	public static void main(String[] args) {
		
		getAuthor();
		
		Scanner sc = new Scanner(System.in);	
		double entrada = 0.0;
		
		Ex06 ex06 = new Ex06();
		
		
		
		System.out.println("Digite o valor do saldo do ultimo ano : ");
		entrada = sc.nextInt();
		
		ex06.setSaldoMedioUltimoAno(entrada);

		System.out.printf("O limite pre aprovado é : %.2f%n" 
				,ex06.getValorCreditoPreAprovado() 
				);
	
		
		System.out.println("\n" + ex06.toString());
		
		sc.close();
	}
		
	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");	
		System.out.println("---------------------------------------------------\n");
	}
	
}