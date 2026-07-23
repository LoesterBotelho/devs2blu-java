package exercicios22072026parte1;

import java.util.Scanner;

public class Ex03Main {
	public static void main(String[] args) {
		
		getAuthor();
		
		Scanner sc = new Scanner(System.in);	
		int entrada = 0;
		
		Ex03 ex03 = new Ex03();
		
		System.out.println("Digite a o preço da caixa de Laranja : ");
		entrada = sc.nextInt();
		
		ex03.setPrecoCxLaranja(entrada);
		
		System.out.println("Digite a o preço da caixa de Limão : ");
		entrada = sc.nextInt();
		
		ex03.setPrecoCxLimao(entrada);
				
		
		System.out.println("Digite a o preço da caixa de Morango : ");
		entrada = sc.nextInt();
		
		ex03.setPrecoCxMorango(entrada);
				
					
		System.out.printf("Preço Unitário da Laranja ..... R$ %.2f%n" , ex03.getPrecoUnitarioLaranja() );
		System.out.printf("Preço Unitário da Limão ....... R$ %.2f%n" , ex03.getPrecoUnitarioLimao() );
		System.out.printf("Preço Unitário da Morango ..... R$ %.2f%n" , ex03.getPrecoUnitarioMorango() );
		
		
		System.out.println("\n" + ex03.toString());
		
		sc.close();
	}
		
	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");	
		System.out.println("---------------------------------------------------\n");
	}
	
}