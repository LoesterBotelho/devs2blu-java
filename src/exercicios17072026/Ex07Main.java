package exercicios17072026;

import java.util.Scanner;

public class Ex07Main {

	public static void main(String[] args) {
		getAuthor();
		
		Scanner sc = new Scanner(System.in);
		
		Ex07 ex07 = new Ex07();
		
		System.out.println("Digite o seu nome : ");
		String entradaString = sc.nextLine();	
		
		ex07.setNome(entradaString);
		
		System.out.println("Digite sua idade : ");
		int entrada = sc.nextInt();		
		
		ex07.setIdade(entrada);
		
		System.out.println("Você : " + ex07.getNome() + " viveu " + ex07.getDiasVivo() );
		
		sc.close();		
	}
	
	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");	
		System.out.println("---------------------------------------------------\n");
	}
	
}
