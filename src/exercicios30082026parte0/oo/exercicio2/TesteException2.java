package exercicios30082026parte0.oo.exercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TesteException2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Eu sei dividir (Apenas números maiores que 0)");

		boolean loop = true;

		while (loop) {
			try {
				
				System.out.println("Informe o primeiro valor: ");
				int x = sc.nextInt();
				if (x < 0) {
					throw new IllegalArgumentException("Erro: O primeiro valor deve ser maior ou igual a zero.");
				}

				System.out.println("Informe o segundo valor: ");
				int y = sc.nextInt();
				if (y < 0) {
					throw new IllegalArgumentException("Erro: O segundo valor deve ser maior ou igual a zero.");
				}

				// Realizamos a divisão inteira primeiro para forçar a ArithmeticException se y for 0
				int divisaoInteira = x / y; 
				
				// Se passou daqui sem erro, fazemos o cast para double para exibir o decimal correto se houver
				double r = ((double) x / y);
				System.out.println("Resultado da divisão é " + r);

				loop = false; // Se executou sem erros, encerra o loop

			} catch (InputMismatchException e) {
				System.out.println("Erro: Digite apenas números inteiros válidos!");
				sc.nextLine(); // Limpa o buffer do scanner
			} catch (ArithmeticException e) {
				System.out.println("Erro: Não é possível dividir um número por zero!");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		sc.close();
	}
}