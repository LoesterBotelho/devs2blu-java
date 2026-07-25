package exercicios24072026parte1;

import java.util.Scanner;

public class Ex04Main {

	public static void main(String[] args) {
		
		int tentativa = 3;
		int tentativaCount = 0;
		String senhaCorreta = "123Aa";
		String senhaDigitada = "";
		
		Scanner sc = new Scanner(System.in);
		
		while (tentativa > 0) {
			
			tentativa--;
			tentativaCount++;
			
			System.out.println("Digite Sua Senha : ");
			senhaDigitada = sc.nextLine();
			
			if (senhaDigitada.equals(senhaCorreta)) {
				System.out.println("Login efetuado com sucesso");
				break;
			} else {
				System.out.println("Login invalido !!! tentativa : " + tentativaCount);
			}
			
			if (tentativa == 0 ) {
				System.out.println("3 tentativa inválida - login bloqueado !!!");
			}			
			
		}

		sc.close();			 
	}
}
