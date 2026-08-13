package exercicios12082026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuController {

	public static void inicializarDados(List<Cliente> clientes, List<Tema> temas, List<Aluguel> alugueis) {
		Cliente cliente1 = new Cliente("Loester", "123.456.789-77",
				"Rua Heinrich Hosang, 605, no bairro Victor Konder, em Blumenau, Santa Catarina");
		Cliente cliente2 = new Cliente("Heloisa", "222.456.789-77",
				"Rua São Paulo, número 1147, no bairro Victor Konder");

		clientes.add(cliente1);
		clientes.add(cliente2);

		temas.add(new Tema("IronMan - Homem de Ferro", 16000.00, "Vermelha / Amarela",
				new String[] { "Boneco IronMan Tony Stark 2m", "Luzes do Reator Arc" }));
		temas.add(new Tema("Cinderela Rosa", 7000.00, "Rosa",
				new String[] { "Castelo da Cinderela", "Bruxa velha oferecendo maçã", "Carruagem de abóbora" }));

		Aluguel aluguel1 = new Aluguel("IronMan - Homem de Ferro", "12/08/2026", "19:00", "23:59", 16000.00,
				"Rua Heinrich Hosang, 605, no bairro Victor Konder, em Blumenau, Santa Catarina");
		aluguel1.setCliente(cliente1);
		cliente1.adicionarAluguel(aluguel1);

		alugueis.add(aluguel1);
	}

	public static void exibirMenu() {
		System.out.println("\n MENU ");
		System.out.println("1 - Cadastrar Cliente");
		System.out.println("2 - Listar Todos Clientes");
		System.out.println("3 - Cadastrar Aluguel");
		System.out.println("4 - Listar Todos Alugueis");
		System.out.println("5 - Cadastrar Tema");
		System.out.println("6 - Listar Todos Temas");
		System.out.println("0 - Fechar Programa");
		System.out.print("Digite a opção selecionada: ");
	}

	public static void cadastrarCliente(Scanner sc, List<Cliente> clientes) {
		Cliente novoCliente = new Cliente();

		System.out.print("Digite o nome do cliente: ");
		String nome = sc.nextLine();
		novoCliente.setNome(nome);

		System.out.print("Digite o CPF do cliente: ");
		String cpf = sc.nextLine();
		novoCliente.setCpf(cpf);

		System.out.print("Digite o endereço completo do cliente: ");
		String endereco = sc.nextLine();
		novoCliente.setEndereco(endereco);

		clientes.add(novoCliente);
		System.out.println("Cliente cadastrado com sucesso!");
	}

	public static void listarCliente(Scanner sc, List<Cliente> clientes) {
		if (clientes.isEmpty()) {
			System.out.println("Nenhum cliente cadastrado.");
			return;
		}
		for (Cliente item : clientes) {
			System.out.println(item.toString());
		}
	}

	public static void cadastrarAluguel(Scanner sc, List<Aluguel> alugueis, List<Cliente> clientes, List<Tema> temas) {
		if (clientes.isEmpty()) {
			System.out.println("Erro: Cadastre um cliente antes de realizar um aluguel.");
			return;
		}
		if (temas.isEmpty()) {
			System.out.println("Erro: Cadastre um tema antes de realizar um aluguel.");
			return;
		}

		Cliente clienteEncontrado = null;

		escolherCliente: while (true) {
			System.out.println("\n SELECIONE O CLIENTE ");
			System.out.println("Clientes cadastrados:");
			for (int i = 0; i < clientes.size(); i++) {
				System.out.println((i + 1) + " - " + clientes.get(i).getNome());
			}
			System.out.print("Digite o NÚMERO do cliente (ou 0 para cancelar): ");

			if (!sc.hasNextInt()) {
				System.out.println("Erro: Digite um número válido.");
				sc.next();
				continue;
			}

			int opcaoCliente = sc.nextInt();
			sc.nextLine(); // limpar buffer

			if (opcaoCliente == 0) {
				System.out.println("Cadastro de aluguel cancelado.");
				return;
			}

			int indice = opcaoCliente - 1;
			if (indice >= 0 && indice < clientes.size()) {
				clienteEncontrado = clientes.get(indice);
				break escolherCliente;
			}

			System.out.println("Erro: Cliente inválido ou não encontrado! Tente novamente.");
		}

		Tema temaEncontrado = null;

		escolherTema: while (true) {
			System.out.println("\n SELECIONE O TEMA ");
			System.out.println("Temas cadastrados:");
			for (int i = 0; i < temas.size(); i++) {
				System.out.println(
						(i + 1) + " - " + temas.get(i).getNome() + " (R$ " + temas.get(i).getValorAluguel() + ")");
			}
			System.out.print("Digite o NÚMERO do tema (ou 0 para cancelar): ");

			if (!sc.hasNextInt()) {
				System.out.println("Erro: Digite um número válido.");
				sc.next();
				continue;
			}

			int opcaoTema = sc.nextInt();
			sc.nextLine(); // limpar buffer

			if (opcaoTema == 0) {
				System.out.println("Cadastro de aluguel cancelado.");
				return;
			}

			int indice = opcaoTema - 1;
			if (indice >= 0 && indice < temas.size()) {
				temaEncontrado = temas.get(indice);
				break escolherTema;
			}

			System.out.println("Erro: Tema inválido ou não encontrado! Tente novamente.");
		}

		Aluguel novoAluguel = new Aluguel();
		novoAluguel.setCliente(clienteEncontrado);
		novoAluguel.setNomeTema(temaEncontrado.getNome());

		double valorBruto = temaEncontrado.getValorAluguel();
		novoAluguel.setValorCobrado(valorBruto);

		System.out.print("Digite a data da festa (ex: 12/08/2026): ");
		novoAluguel.setDataFesta(sc.nextLine());

		System.out.print("Digite a hora de início (ex: 19:00): ");
		novoAluguel.setHoraInicio(sc.nextLine());

		System.out.print("Digite a hora de término (ex: 23:59): ");
		novoAluguel.setHoraTermino(sc.nextLine());

		System.out.print("Digite o endereço da festa: ");
		novoAluguel.setEndereco(sc.nextLine());

		clienteEncontrado.adicionarAluguel(novoAluguel);
		alugueis.add(novoAluguel);

		double valorFinal = novoAluguel.calcularValorFinal();

		System.out.println("\nAluguel cadastrado com sucesso!");

		if (valorFinal < valorBruto) {
			double descontoAplicado = valorBruto - valorFinal;
			System.out.println(" DESCONTO APLICADO PARA CLIENTE ANTIGO (10%) ");
			System.out.println("Valor Original: R$ " + valorBruto);
			System.out.println("Desconto: R$ " + descontoAplicado);
			System.out.println("Valor Total com Desconto: R$ " + valorFinal);
		} else {
			System.out.println("Valor Total: R$ " + valorFinal);
		}
	}

	public static void listarAluguel(Scanner sc, List<Aluguel> alugueis) {
		if (alugueis.isEmpty()) {
			System.out.println("Nenhum aluguel cadastrado.");
			return;
		}
		for (Aluguel item : alugueis) {
			System.out.println(item.toString());
		}
	}

	public static void cadastrarTema(Scanner sc, List<Tema> temas) {
		System.out.print("Digite o nome do tema: ");
		String nome = sc.nextLine();

		System.out.print("Digite a cor da toalha: ");
		String corToalha = sc.nextLine();

		System.out.print("Digite o valor do aluguel do tema: ");
		double valorAluguel = sc.nextDouble();
		sc.nextLine(); // limpar buffer

		List<String> listaItens = new ArrayList<>();

		System.out.println("Digite os itens do tema. Digite \"SAIR\" para encerrar a inserção de itens:");

		digitarItens: while (true) {
			String entrada = sc.nextLine();

			if (entrada.equalsIgnoreCase("SAIR")) {
				break digitarItens;
			}

			listaItens.add(entrada);
		}

		String[] itensTema = listaItens.toArray(new String[0]);

		temas.add(new Tema(nome, valorAluguel, corToalha, itensTema));
		System.out.println("Tema cadastrado com sucesso!");
	}

	public static void listarTema(Scanner sc, List<Tema> temas) {
		if (temas.isEmpty()) {
			System.out.println("Nenhum tema cadastrado.");
			return;
		}
		for (Tema item : temas) {
			System.out.println(item.toString());
		}
	}
}