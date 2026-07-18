package exercicios17072026parte1;

import java.util.Scanner;

public class Ex04Main {

	public static void main(String[] args) {
		getAuthor();
	
		Scanner sc = new Scanner(System.in);
				
		Ex04 ex04 = new Ex04();
		
		System.out.println("Digite seu ano de nascimento : ");
		int entrada = sc.nextInt();
		
		ex04.setAnoNascimento(entrada);

		System.out.println("Sua idade é : " + ex04.getIdade());
		
		System.out.println(ex04.toString());
		
		sc.close();
	}
	
	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");	
		System.out.println("---------------------------------------------------\n");
	}
	
}
