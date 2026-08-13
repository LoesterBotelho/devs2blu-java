package exercicios13082026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Leitor> leitores = new ArrayList<>();
		List<Livro> livros = new ArrayList<>();
		List<Emprestimo> emprestimos = new ArrayList<>();

		MenuController.inicializarDados(leitores, livros, emprestimos);

		int opcao = -1;
		
		do {
			MenuController.exibirMenu();
			if (!sc.hasNextInt()) {
				System.out.println("Opção inválida!");
				sc.next();
				continue;
			}
			opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
			case 1:
				MenuController.cadastrarLeitor(sc, leitores);
				break;
			case 2:
				MenuController.listarLeitores(leitores);
				break;
			case 3:
				MenuController.cadastrarLivro(sc, livros);
				break;
			case 4:
				MenuController.listarLivros(livros);
				break;
			case 5:
				MenuController.cadastrarEmprestimo(sc, emprestimos, leitores, livros);
				break;
			case 6:
				MenuController.listarEmprestimos(emprestimos);
				break;
			case 0:
				System.out.println("Encerrando o sistema...");
				break;
			default:
				System.out.println("Opção desconhecida!");
			}
		} while (opcao != 0);

		sc.close();
	}
}