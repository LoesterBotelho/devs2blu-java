package exercicios17072026parte2;

import java.util.Scanner;

public class Ex04Main {
	
	public static void main(String[] args) {
		
		getAuthor();
		
		Scanner sc = new Scanner(System.in);	
		
		Ex04 ex04 = new Ex04();
		
		System.out.println("Digite a velocidade do velocimetro : ");
		int entrada = sc.nextInt();
		
		ex04.setVelocidade(entrada);

        System.out.printf("Distância em 5 horas .....: %d km%n", ex04.getDistancia5HorasEmKM());
        System.out.printf("Distância em 8 horas......: %d km%n", ex04.getDistancia8HorasEmKM());
        System.out.printf("Distância em 12 horas.....: %d km%n", ex04.getDistancia12HorasEmKM());
        
		
		System.out.println("\n" + ex04.toString());
		
		sc.close();
	}
		
	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");	
		System.out.println("---------------------------------------------------\n");
	}
	
}
