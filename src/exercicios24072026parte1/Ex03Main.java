package exercicios24072026parte1;

import java.util.Scanner;

public class Ex03Main {

	
	public static boolean verificaNumeroPrimo(int numero) {
		
	    // Números menores ou iguais a 1 não são primos
	    if (numero <= 1) {
	        return false;
	    }
	    
	    // O número 2 é o único primo par
	    if (numero == 2) {
	        return true;
	    }
	    
	    // Elimina todos os outros números pares
	    if (numero % 2 == 0) {
	        return false;
	    }
	    
	    return true;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int numeroDigitado = 0;

		System.out.println("Digite um número : ");
		numeroDigitado = sc.nextInt();
		
		boolean ehPrimo = verificaNumeroPrimo(numeroDigitado);
		
		if (ehPrimo) {
			System.out.println("Numero " + numeroDigitado + " é Primo");
		} else {
			System.out.println("Soma : " + numeroDigitado + " Não é Primo");
		}
		
		sc.close();	
	}
}
