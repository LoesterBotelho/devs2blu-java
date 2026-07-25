package exercicios24072026parte1;

import java.util.Scanner;

public class Ex02Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numeroInferior = 0;
		int numeroSuperior = 0;
		int soma = 0;
		String numeros = "";
		Boolean FlagPrimeiraVez = true;
		
		System.out.println("Digite um número Inferior : ");
		numeroInferior = sc.nextInt();
		
		System.out.println("Digite um número Superior : ");
		numeroSuperior = sc.nextInt();
		
		for (var i=numeroInferior+1 ; numeroSuperior-1 >= i ; i++) {

			if ( i % 2 == 0) {
					
				if (FlagPrimeiraVez) {
					numeros += "" + i;
					FlagPrimeiraVez = false;
				} else {
					numeros += ", " + i;
				}

				soma += i;
			
			}
			
		}
		
		System.out.println("Saída : " + numeros);
		System.out.println("Soma : " + soma);
		
		sc.close();	
	}

}
