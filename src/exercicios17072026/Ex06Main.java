package exercicios17072026;

import java.util.Scanner;

public class Ex06Main {

	public static void main(String[] args) {
		getAuthor();
		
		Scanner sc = new Scanner(System.in);
		
		Ex06 ex06 = new Ex06();
		
		System.out.println("Digite a quantidade de paginas : ");
		int entrada = sc.nextInt();		
		
		ex06.setQuantidadePaginas(entrada);
		
		System.out.println("Preco total a pagar : " + ex06.getPreco());
		
		System.out.println(ex06.toString());
		
		sc.close();
	}
	
	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");	
		System.out.println("---------------------------------------------------\n");
	}
	
}
