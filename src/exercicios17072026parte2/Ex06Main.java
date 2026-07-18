package exercicios17072026parte2;

import java.util.Scanner;

public class Ex06Main {
	
	public static void main(String[] args) {
		
		getAuthor();
		
		Scanner sc = new Scanner(System.in);	
		
		Ex06 ex06 = new Ex06();
		
		System.out.println("Digite a quantidade metros quadrados : ");
		double entrada = sc.nextDouble();
		
		ex06.setMetrosQuadradosM2(entrada);
		System.out.println("Valor Acres ..................: " + ex06.getAcres());
		System.out.println("Valor Pes quadrados FT2 ......: " + ex06.getPesQuadradosFT2());
		System.out.println("Valor Hectares ...............: " + ex06.getHectares());
		
		System.out.println("\n" + ex06.toString());
		
		sc.close();
	}
		
	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");	
		System.out.println("---------------------------------------------------\n");
	}
	
}
