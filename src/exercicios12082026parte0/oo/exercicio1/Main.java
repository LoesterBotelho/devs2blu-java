package exercicios12082026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void exibirMenu() {
		System.out.println("MENU");
		System.out.println("1 - Cadastrar Cliente");
		System.out.println("2 - Listar Todos clientes");
		System.out.println("3 - Cadastrar Aluguel");
		System.out.println("4 - Listar Todos Aluguel");
		System.out.println("5 - Cadastrar Tema");
		System.out.println("6 - Listar Todos Tema");
		System.out.println("0 - Fechar Programa");
		System.out.println("Digite opção selecionada : ");
	}

	public static void cadastrarCliente(Scanner sc, List<Cliente> clientes) {

		Cliente novoCliente = new Cliente();
		
		System.out.println("Digite nome do cliente : ");
		String nome = sc.nextLine();
		novoCliente.setNome(nome);
		
		System.out.println("Digite cpf do cliente : ");
		String cpf = sc.nextLine();
		novoCliente.setCpf(cpf);
		
		System.out.println("Digite endereço compleo do cliente : ");
		String endereco = sc.nextLine();
		novoCliente.setEndereco(endereco);
		
		clientes.add(novoCliente);
	}

	public static void ListarCliente(Scanner sc, List<Cliente> clientes) {

		for ( Cliente item : clientes ) {
			System.out.println(item.toString());
		}
		
	}

	public static void cadastrarAluguel(Scanner sc, List<Aluguel> alugueis) {

		
//		String nomeTema;
//		String dataFesta;
//		String horaInicio;
//		String horaTermino;
//		double valorCobrado;
//		String endereco;
		
	}

	public static void ListarAluguel(Scanner sc, List<Aluguel> alugueis) {

		for ( Aluguel item : alugueis ) {
			System.out.println(item.toString());
		}
		
	}

	public static void cadastrarTema(Scanner sc, List<Tema> temas) {
		
		System.out.println("Digite nome do tema : ");
		String nome = sc.nextLine();
				
		System.out.println("Digite cor da toalha : ");
		String corToalha = sc.nextLine();
				
		System.out.println("Digite valor do aluguel : ");
		double valorAluguel = sc.nextDouble();

		sc.nextLine(); // limpar buffer // evitar erro
		
		List<String> listaItens = new ArrayList<String>();
		
		String entrada = "";
				
		System.out.println("Digite um item e aperte enter");
		System.out.println("Digite um item e aperte enter");
		System.out.println("Pra terminar o cadastr \"SAIR\"");
		
		while(true) {
				entrada = sc.nextLine();
						
			if (entrada == "SAIR") break;
			
			listaItens.add(entrada);
			
		}
		
		String[] itensTema = listaItens.toArray(new String[listaItens.size()]);
		
		temas.add( new Tema(nome, valorAluguel, corToalha, itensTema) ); 

	}

	public static void ListarTema(Scanner sc, List<Tema> temas) {

		for ( Tema item : temas ) {
			System.out.println(item.toString());
		}
		
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcao = -1;
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<Tema> temas = new ArrayList<Tema>();
		List<Aluguel> alugueis = new ArrayList<Aluguel>();
		
		clientes.add( new Cliente("Loester","123.456.789-77","Rua Heinrich Hosang, 605, no bairro Victor Konder, em Blumenau, Santa Catarina") );
		clientes.add( new Cliente("Heloisa","222.456.789-77","Rua São Paulo, número 1147, no bairro Victor Konder") );
					
		temas.add( new Tema("IronMan - Homen de Ferro", 16000.00, "Vermelha / Amarela", new String[] { "Boneco IronMan Tonny Stark 2m", "Luzes do Reator Arc" }) );
		temas.add( new Tema("Cinderela Rosa", 7000.00, "Rosa", new String[] { "Castelo da Cinderela", "Bruxa velha oferecendo maça", "Caroagem de abobora" }) );
		
		alugueis.add( new Aluguel("IronMan","12/08/2026","19:00","23:59",16000.00, "Rua Heinrich Hosang, 605, no bairro Victor Konder, em Blumenau, Santa Catarina") );
		
		while (true) {

			exibirMenu();

			opcao = sc.nextInt();

			// limpar buffer // evitar problema de scanner
			sc.nextLine();

			if (opcao == 0) break; // sair do loop // fim do programa
			
			switch (opcao) {
			case 1:
				cadastrarCliente(sc, clientes);
				break;
			case 2:
				ListarCliente(sc, clientes);
				break;
			case 3:
				cadastrarAluguel(sc, alugueis);
				break;
			case 4:
				ListarAluguel(sc, alugueis);
				break;
			case 5:
				cadastrarTema(sc, temas);
				break;
			case 6:
				ListarTema(sc, temas);
				break;
			default:
				System.out.println("Erro : Opção Invalida");
			}
			

		}

		sc.close();
		
	}
}
