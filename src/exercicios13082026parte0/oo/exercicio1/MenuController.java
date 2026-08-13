package exercicios13082026parte0.oo.exercicio1;

import java.util.List;
import java.util.Scanner;

public class MenuController {

	public static void inicializarDados(List<Leitor> leitores, List<Livro> livros, List<Emprestimo> emprestimos) {
		Leitor l1 = new Leitor("Ana Souza", "ana@email.com", "(47) 99999-1111");
		Leitor l2 = new Leitor("Carlos Silva", "carlos@email.com", "(47) 98888-2222");
		leitores.add(l1);
		leitores.add(l2);

		Livro liv1 = new Livro("Java: Como Programar", "Deitel", "978-8543007", 3);
		Livro liv2 = new Livro("Arquitetura Limpa", "Robert C. Martin", "978-8550804", 2);
		livros.add(liv1);
		livros.add(liv2);

		Emprestimo emp1 = new Emprestimo("10/08/2026", "24/08/2026", l1, liv1);
		liv1.emprestarExemplar();
		l1.adicionarEmprestimo(emp1);
		emprestimos.add(emp1);
	}

	public static void exibirMenu() {
		System.out.println("\n MENU BIBLIOTECA ");
		System.out.println("1 - Cadastrar Leitor");
		System.out.println("2 - Listar Leitores");
		System.out.println("3 - Cadastrar Livro");
		System.out.println("4 - Listar Livros");
		System.out.println("5 - Realizar Empréstimo");
		System.out.println("6 - Listar Empréstimos");
		System.out.println("0 - Sair");
		System.out.print("Escolha uma opção: ");
	}

	public static void cadastrarLeitor(Scanner sc, List<Leitor> leitores) {
		System.out.print("Nome do leitor: ");
		String nome = sc.nextLine();
		System.out.print("E-mail do leitor: ");
		String email = sc.nextLine();
		System.out.print("Telefone do leitor: ");
		String telefone = sc.nextLine();

		leitores.add(new Leitor(nome, email, telefone));
		System.out.println("Leitor cadastrado com sucesso!");
	}

	public static void listarLeitores(List<Leitor> leitores) {
		if (leitores.isEmpty()) {
			System.out.println("Nenhum leitor cadastrado.");
			return;
		}
		for (Leitor l : leitores) {
			System.out.println(l);
		}
	}

	public static void cadastrarLivro(Scanner sc, List<Livro> livros) {
		System.out.print("Título do livro: ");
		String titulo = sc.nextLine();
		System.out.print("Autor do livro: ");
		String autor = sc.nextLine();
		System.out.print("ISBN: ");
		String isbn = sc.nextLine();
		System.out.print("Quantidade de exemplares: ");
		int qtd = sc.nextInt();
		sc.nextLine(); // limpar buffer

		livros.add(new Livro(titulo, autor, isbn, qtd));
		System.out.println("Livro cadastrado com sucesso!");
	}

	public static void listarLivros(List<Livro> livros) {
		if (livros.isEmpty()) {
			System.out.println("Nenhum livro cadastrado.");
			return;
		}
		for (Livro liv : livros) {
			System.out.println(liv);
		}
	}

	public static void cadastrarEmprestimo(Scanner sc, List<Emprestimo> emprestimos, List<Leitor> leitores,
			List<Livro> livros) {
		if (leitores.isEmpty() || livros.isEmpty()) {
			System.out.println("Erro: É necessário ter leitores e livros cadastrados.");
			return;
		}

		System.out.println("\nSelecione o Leitor:");
		for (int i = 0; i < leitores.size(); i++) {
			System.out.println((i + 1) + " - " + leitores.get(i).getNome());
		}
		int idxLeitor = sc.nextInt() - 1;
		sc.nextLine();
		Leitor leitor = leitores.get(idxLeitor);

		System.out.println("\nSelecione o Livro:");
		for (int i = 0; i < livros.size(); i++) {
			System.out.println((i + 1) + " - " + livros.get(i).getTitulo() + " (Disponíveis: "
					+ livros.get(i).getQtdExemplares() + ")");
		}
		int idxLivro = sc.nextInt() - 1;
		sc.nextLine();
		Livro livro = livros.get(idxLivro);

		if (!livro.temExemplarDisponivel()) {
			System.out.println("Erro: Não há exemplares disponíveis deste livro!");
			return;
		}

		System.out.print("Data do empréstimo (ex: 13/08/2026): ");
		String dataEmp = sc.nextLine();
		System.out.print("Data de devolução (ex: 27/08/2026): ");
		String dataDev = sc.nextLine();

		Emprestimo novoEmp = new Emprestimo(dataEmp, dataDev, leitor, livro);
		livro.emprestarExemplar();
		leitor.adicionarEmprestimo(novoEmp);
		emprestimos.add(novoEmp);

		System.out.println("Empréstimo realizado com sucesso!");
		if (leitor.isLeitorAsseduo()) {
			System.out.println("Aviso: Este leitor atingiu o status de Asíduo!");
		}
	}

	public static void listarEmprestimos(List<Emprestimo> emprestimos) {
		if (emprestimos.isEmpty()) {
			System.out.println("Nenhum empréstimo cadastrado.");
			return;
		}
		for (Emprestimo e : emprestimos) {
			System.out.println(e);
		}
	}
}