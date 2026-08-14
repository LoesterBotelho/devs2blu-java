package exercicios14082026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcao;

		List<Cliente> clientes = new ArrayList<>();
		List<Tema> temas = new ArrayList<>();
		List<Aluguel> alugueis = new ArrayList<>();
		List<TransacaoFinanceira> transacoes = new ArrayList<>();

		MenuController.inicializarDados(clientes, temas, alugueis, transacoes);

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
				MenuController.cadastrarCliente(sc, clientes);
				break;
			case 2:
				MenuController.listarCliente(sc, clientes);
				break;
			case 3:
				MenuController.cadastrarAluguel(sc, alugueis, clientes, temas, transacoes);
				break;
			case 4:
				MenuController.listarAluguel(sc, alugueis);
				break;
			case 5:
				MenuController.cadastrarTema(sc, temas);
				break;
			case 6:
				MenuController.listarTema(sc, temas);
				break;
			case 7:
				MenuController.processarTransacoes(sc, transacoes);
				break;
			default:
				System.out.println("Erro: Opção Inválida!");
			}
		}

		sc.close();
	}
}