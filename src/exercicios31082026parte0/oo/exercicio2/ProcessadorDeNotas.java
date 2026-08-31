package exercicios31082026parte0.oo.exercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProcessadorDeNotas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] pesos = { 2.0, 3.0, 0.0 }; // Vetor com 3 pesos (o último é zero para testar)
		boolean loop = true;

		while (loop) {
			try {
				System.out.println("Digite o índice do peso (0 a 2): ");
				int indice = sc.nextInt();

				System.out.println("Digite o valor da nota: ");
				double nota = sc.nextDouble();

				double pesoEscolhido = pesos[indice];

				if (pesoEscolhido == 0) {
					throw new ArithmeticException("Erro: O peso selecionado é zero, divisão inválida.");
				}

				double resultado = nota / pesoEscolhido;
				System.out.println("Nota ponderada: " + resultado);

				loop = false; // Encerra o loop se tudo ocorrer bem

			} catch (InputMismatchException e) {
				System.out.println("Erro: Insira dados numéricos válidos.");
				sc.nextLine(); // Limpa o scanner
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Erro: Índice do vetor inexistente (use 0, 1 ou 2).");
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());
			} finally {
				System.out.println("Ciclo de processamento encerrado.\n");
			}
		}
		sc.close();
	}
}
