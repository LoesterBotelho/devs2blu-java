package exercicios13082026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcao;

		List<Funcionario> funcionarios = new ArrayList<>();
		List<Equipe> equipes = new ArrayList<>();
		List<Projeto> projetos = new ArrayList<>();
		List<Tarefa> tarefas = new ArrayList<>();

		MenuController.inicializarDados(funcionarios, equipes, projetos, tarefas);

		principal: while (true) {
			MenuController.exibirMenu();

			if (!sc.hasNextInt()) {
				System.out.println("Erro: Digite um número válido.");
				sc.next();
				continue;
			}

			opcao = sc.nextInt();
			sc.nextLine(); // limpar buffer

			if (opcao == 0) {
				System.out.println("Encerrando o programa de Gestão de Projetos...");
				break principal;
			}

			switch (opcao) {
			case 1:
				MenuController.cadastrarFuncionario(sc, funcionarios);
				break;
			case 2:
				MenuController.listarFuncionarios(funcionarios);
				break;
			case 3:
				MenuController.cadastrarTarefa(sc, tarefas);
				break;
			case 4:
				MenuController.listarTarefas(tarefas);
				break;
			case 5:
				MenuController.cadastrarProjeto(sc, projetos, equipes, tarefas);
				break;
			case 6:
				MenuController.listarProjetos(projetos);
				break;
			default:
				System.out.println("Erro: Opção Inválida!");
			}
		}

		sc.close();
	}
}