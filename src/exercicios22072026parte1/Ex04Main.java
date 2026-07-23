package exercicios22072026parte1;

import java.util.Scanner;

public class Ex04Main {
	public static void main(String[] args) {
		
		getAuthor();
		
		Scanner sc = new Scanner(System.in);	
		double entrada = 0.0;
		char operacao = '+';
		
		Ex04 ex04 = new Ex04();
		
		
		
		System.out.println("Digite o primeiro número: ");
		entrada = sc.nextInt();
		
		ex04.setNumeroA(entrada);
		
		System.out.println("Digite o segundo número: ");
		entrada = sc.nextInt();
		
		ex04.setNumeroB(entrada);
		
		
		System.out.println("OPERAÇÃO SOMA É +: ");
		System.out.println("OPERAÇÃO SUBTRAÇÃO É - : ");
		System.out.println("OPERAÇÃO MULTIPLICAÇÃO É * : ");
		System.out.println("OPERAÇÃO DIVISÃO É / : ");
		System.out.println("\nDigite a operação : ");
		operacao = sc.next().charAt(0);
		
		ex04.setOperacao(operacao);
			
		System.out.printf("O Resultado da operação %s é : %.2f%n" 
				,ex04.getOperacaoTexto() 
				,ex04.getResultado() 
				);
	
		
		System.out.println("\n" + ex04.toString());
		
		sc.close();
	}
		
	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");	
		System.out.println("---------------------------------------------------\n");
	}
	
}