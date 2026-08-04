package exercicios30072026parte1.oo.classes;

import java.util.Scanner;

public class Console {

	private final Scanner scanner;

	public Console() {
		this.scanner = new Scanner(System.in);
	}

	public int lerInteiro(String mensagem) {

		System.out.println(mensagem);

		int valor = scanner.nextInt();

		limparBuffer();

		return valor;
	}

	public String lerTexto(String mensagem) {

		System.out.println(mensagem);

		return scanner.nextLine();
	}

	public void limparBuffer() {

		scanner.nextLine();

	}

	public void imprimir(String mensagem) {

		System.out.println(mensagem);

	}

	public void fechar() {

		scanner.close();

	}

}