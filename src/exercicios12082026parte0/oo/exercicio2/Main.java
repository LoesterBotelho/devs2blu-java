package exercicios12082026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcao;

		List<Autor> autores = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		Biblioteca biblioteca = new Biblioteca();

		MenuController.inicializarDados(autores, categorias, biblioteca);

		principal: while (true) {
			MenuController.exibirMenu();

			if (!sc.hasNextInt()) {
				System.out.println("Erro: Digite um número válido.");
				sc.next();
				continue;
			}

			opcao = sc.nextInt();
			sc.nextLine();

			if (opcao == 0) {
				System.out.println("Encerrando o programa...");
				break principal;
			}

			switch (opcao) {
			case 1:
				MenuController.cadastrarAutor(sc, autores);
				break;
			case 2:
				MenuController.listarAutores(autores);
				break;
			case 3:
				MenuController.cadastrarCategoria(sc, categorias);
				break;
			case 4:
				MenuController.listarCategorias(categorias);
				break;
			case 5:
				MenuController.cadastrarLivro(sc, biblioteca, autores, categorias);
				break;
			case 6:
				MenuController.listarAcervo(biblioteca);
				break;
			default:
				System.out.println("Erro: Opção Inválida!");
			}
		}

		sc.close();
	}
}