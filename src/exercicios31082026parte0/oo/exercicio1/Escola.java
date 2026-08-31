package exercicios31082026parte0.oo.exercicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

import exercicios31082026parte0.oo.exercicio1.customexception.*;

public class Escola {

	public static void matricularAluno(int idade) throws IdadeInvalidaException {
		if (idade < 6) {
			// Lança a exceção customizada se a regra não for atendida
			throw new IdadeInvalidaException("Erro: O aluno precisa ter pelo menos 6 anos.");
		}
		System.out.println("Matrícula realizada com sucesso!");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean loop = true;

		while (loop) {
			try {
				System.out.println("Informe a idade do aluno: ");
				int idade = sc.nextInt();

				matricularAluno(idade);
				loop = false; // Encerra se passar sem erro

			} catch (InputMismatchException e) {
				System.out.println("Erro: Digite apenas números inteiros.");
				sc.nextLine(); // Limpa o buffer
			} catch (IdadeInvalidaException e) {
				System.out.println(e.getMessage());
			} finally {
				System.out.println("Tentativa de matrícula processada.\n");
			}
		}
		sc.close();
	}
}