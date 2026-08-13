package exercicios12082026parte0.oo.exercicio2;

import java.util.List;
import java.util.Scanner;

public class MenuController {

	public static void inicializarDados(List<Autor> autores, List<Categoria> categorias, Biblioteca biblioteca) {
		Autor autor1 = new Autor("Machado de Assis", "Brasileira");
		Autor autor2 = new Autor("J.K. Rowling", "Britânica");

		autores.add(autor1);
		autores.add(autor2);

		Categoria cat1 = new Categoria("Romance");
		Categoria cat2 = new Categoria("Fantasia");

		categorias.add(cat1);
		categorias.add(cat2);

		Livro livro1 = new Livro("Dom Casmurro", autor1, cat1);
		Livro livro2 = new Livro("Harry Potter e a Pedra Filosofal", autor2, cat2);

		biblioteca.adicionarLivro(livro1);
		biblioteca.adicionarLivro(livro2);
	}

	public static void exibirMenu() {
		System.out.println("\n MENU BIBLIOTECA ");
		System.out.println("1 - Cadastrar Autor");
		System.out.println("2 - Listar Todos Autores");
		System.out.println("3 - Cadastrar Categoria");
		System.out.println("4 - Listar Todas Categorias");
		System.out.println("5 - Cadastrar Livro");
		System.out.println("6 - Listar Acervo da Biblioteca");
		System.out.println("0 - Fechar Programa");
		System.out.print("Digite a opção selecionada: ");
	}

	public static void cadastrarAutor(Scanner sc, List<Autor> autores) {
		System.out.print("Digite o nome do autor: ");
		String nome = sc.nextLine();

		System.out.print("Digite a nacionalidade do autor: ");
		String nacionalidade = sc.nextLine();

		autores.add(new Autor(nome, nacionalidade));
		System.out.println("Autor cadastrado com sucesso!");
	}

	public static void listarAutores(List<Autor> autores) {
		if (autores.isEmpty()) {
			System.out.println("Nenhum autor cadastrado.");
			return;
		}
		for (Autor autor : autores) {
			System.out.println(autor.toString());
		}
	}

	public static void cadastrarCategoria(Scanner sc, List<Categoria> categorias) {
		System.out.print("Digite o nome da categoria: ");
		String nome = sc.nextLine();

		categorias.add(new Categoria(nome));
		System.out.println("Categoria cadastrada com sucesso!");
	}

	public static void listarCategorias(List<Categoria> categorias) {
		if (categorias.isEmpty()) {
			System.out.println("Nenhuma categoria cadastrada.");
			return;
		}
		for (Categoria categoria : categorias) {
			System.out.println(categoria.toString());
		}
	}

	public static void cadastrarLivro(Scanner sc, Biblioteca biblioteca, List<Autor> autores, List<Categoria> categorias) {
		if (autores.isEmpty()) {
			System.out.println("Erro: Cadastre um autor antes de realizar o cadastro de um livro.");
			return;
		}
		if (categorias.isEmpty()) {
			System.out.println("Erro: Cadastre uma categoria antes de realizar o cadastro de um livro.");
			return;
		}

		Autor autorEncontrado = null;
		escolherAutor: while (true) {
			System.out.println("\n SELECIONE O AUTOR ");
			for (int i = 0; i < autores.size(); i++) {
				System.out.println((i + 1) + " - " + autores.get(i).getNome());
			}
			System.out.print("Digite o NÚMERO do autor (ou 0 para cancelar): ");

			if (!sc.hasNextInt()) {
				System.out.println("Erro: Digite um número válido.");
				sc.next();
				continue;
			}

			int opcaoAutor = sc.nextInt();
			sc.nextLine();

			if (opcaoAutor == 0) {
				System.out.println("Cadastro de livro cancelado.");
				return;
			}

			int indice = opcaoAutor - 1;
			if (indice >= 0 && indice < autores.size()) {
				autorEncontrado = autores.get(indice);
				break escolherAutor;
			}

			System.out.println("Erro: Autor inválido! Tente novamente.");
		}

		Categoria categoriaEncontrada = null;
		escolherCategoria: while (true) {
			System.out.println("\n SELECIONE A CATEGORIA ");
			for (int i = 0; i < categorias.size(); i++) {
				System.out.println((i + 1) + " - " + categorias.get(i).getNome());
			}
			System.out.print("Digite o NÚMERO da categoria (ou 0 para cancelar): ");

			if (!sc.hasNextInt()) {
				System.out.println("Erro: Digite um número válido.");
				sc.next();
				continue;
			}

			int opcaoCategoria = sc.nextInt();
			sc.nextLine();

			if (opcaoCategoria == 0) {
				System.out.println("Cadastro de livro cancelado.");
				return;
			}

			int indice = opcaoCategoria - 1;
			if (indice >= 0 && indice < categorias.size()) {
				categoriaEncontrada = categorias.get(indice);
				break escolherCategoria;
			}

			System.out.println("Erro: Categoria inválida! Tente novamente.");
		}

		System.out.print("Digite o título do livro: ");
		String titulo = sc.nextLine();

		Livro novoLivro = new Livro(titulo, autorEncontrado, categoriaEncontrada);
		biblioteca.adicionarLivro(novoLivro);

		System.out.println("Livro cadastrado e adicionado ao acervo da biblioteca com sucesso!");
	}

	public static void listarAcervo(Biblioteca biblioteca) {
		List<Livro> acervo = biblioteca.getAcervo();
		if (acervo.isEmpty()) {
			System.out.println("O acervo da biblioteca está vazio.");
			return;
		}
		for (Livro livro : acervo) {
			System.out.println(livro.toString());
		}
	}
}