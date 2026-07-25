package exercicios24072026parte1;

import java.util.Scanner;

public class Ex05Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String nome = "";
		int qtdMultas = 0;
		double SomaMultas = 0.0;
		
		System.out.println("Digite Seu nome : ");
		nome = sc.nextLine();
				
		System.out.println("Digite qtd de multas : ");
		qtdMultas = sc.nextInt();

		while (qtdMultas <= 0)
			System.out.println("Digite valor da multa : ");
			SomaMultas += sc.nextDouble();
			qtdMultas--;
		}
		
		System.out.println("\nNome : " + nome + "Total de multas : " + SomaMultas);
		
		sc.close();			

}
	
}
