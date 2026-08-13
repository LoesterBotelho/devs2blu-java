package exercicios13082026parte0.oo.exercicio2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class MenuController {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void inicializarDados(List<Funcionario> funcionarios, List<Equipe> equipes, List<Projeto> projetos, List<Tarefa> tarefas) {

		Funcionario f1 = new Funcionario("Loester Botelho");
		Funcionario f2 = new Funcionario("Heloisa");
		funcionarios.add(f1);
		funcionarios.add(f2);


		Equipe equipe1 = new Equipe("Equipe Core Java");
		equipe1.adicionarMembro(f1);
		equipe1.adicionarMembro(f2);
		equipes.add(equipe1);


		LocalDate inicio = LocalDate.of(2026, 8, 10);
		LocalDate fim = LocalDate.of(2026, 8, 14);
		Tarefa t1 = new Tarefa("Modelagem DB", "Criar o diagrama entidade-relacionamento e tabelas iniciais.", inicio, fim);
		tarefas.add(t1);


		Projeto p1 = new Projeto("Sistema de Gestão Interno", equipe1);
		p1.adicionarTarefa(t1);
		projetos.add(p1);
	}

	public static void exibirMenu() {
		System.out.println("\n--- MENU GESTÃO DE PROJETOS ---");
		System.out.println("1 - Cadastrar Funcionário");
		System.out.println("2 - Listar Funcionários");
		System.out.println("3 - Cadastrar Tarefa (Com cálculo de horas úteis)");
		System.out.println("4 - Listar Tarefas");
		System.out.println("5 - Cadastrar Projeto");
		System.out.println("6 - Listar Projetos");
		System.out.println("0 - Sair");
		System.out.print("Digite a opção selecionada: ");
	}

	public static void cadastrarFuncionario(Scanner sc, List<Funcionario> funcionarios) {
		System.out.print("Digite o nome do funcionário: ");
		String nome = sc.nextLine();
		funcionarios.add(new Funcionario(nome));
		System.out.println("Funcionário cadastrado com sucesso!");
	}

	public static void listarFuncionarios(List<Funcionario> funcionarios) {
		if (funcionarios.isEmpty()) {
			System.out.println("Nenhum funcionário cadastrado.");
			return;
		}
		for (Funcionario f : funcionarios) {
			System.out.println("Funcionário [ID=" + f.getId() + ", Nome=" + f.getNome() + "]");
		}
	}

	public static void cadastrarTarefa(Scanner sc, List<Tarefa> tarefas) {
		System.out.print("Digite o nome curto da tarefa: ");
		String nomeCurto = sc.nextLine();

		System.out.print("Digite a descrição longa da tarefa: ");
		String descricao = sc.nextLine();

		LocalDate dataInicio = null;
		LocalDate dataFim = null;

		try {
			System.out.print("Digite a data de início (dd/MM/yyyy): ");
			dataInicio = LocalDate.parse(sc.nextLine(), FORMATTER);

			System.out.print("Digite a data de término (dd/MM/yyyy): ");
			dataFim = LocalDate.parse(sc.nextLine(), FORMATTER);
		} catch (DateTimeParseException e) {
			System.out.println("Erro: Formato de data inválido. Use o padrão dd/MM/yyyy.");
			return;
		}

		Tarefa novaTarefa = new Tarefa(nomeCurto, descricao, dataInicio, dataFim);
		tarefas.add(novaTarefa);
		
		System.out.println("Tarefa cadastrada com sucesso!");
		System.out.println("Total de horas úteis calculadas (Seg-Sex, 08h-12h / 13h-18h): " + novaTarefa.getTotalHorasGastas() + "h");
	}

	public static void listarTarefas(List<Tarefa> tarefas) {
		if (tarefas.isEmpty()) {
			System.out.println("Nenhuma tarefa cadastrada.");
			return;
		}
		for (Tarefa t : tarefas) {
			System.out.println(t);
		}
	}

	public static void cadastrarProjeto(Scanner sc, List<Projeto> projetos, List<Equipe> equipes, List<Tarefa> tarefas) {
		System.out.print("Digite o nome do projeto: ");
		String nomeProjeto = sc.nextLine();

		
		System.out.print("Digite o nome da equipe responsável: ");
		String nomeEquipe = sc.nextLine();
		Equipe novaEquipe = new Equipe(nomeEquipe);
		equipes.add(novaEquipe);

		Projeto novoProjeto = new Projeto(nomeProjeto, novaEquipe);

		if (!tarefas.isEmpty()) {
			System.out.println("Deseja vincular alguma tarefa existente ao projeto? (s/n): ");
			if (sc.nextLine().equalsIgnoreCase("s")) {
				for (int i = 0; i < tarefas.size(); i++) {
					System.out.println((i + 1) + " - " + tarefas.get(i));
				}
				System.out.print("Digite o número da tarefa: ");
				int idx = sc.nextInt() - 1;
				sc.nextLine();
				if (idx >= 0 && idx < tarefas.size()) {
					novoProjeto.adicionarTarefa(tarefas.get(idx));
				}
			}
		}

		projetos.add(novoProjeto);
		System.out.println("Projeto cadastrado com sucesso!");
	}

	public static void listarProjetos(List<Projeto> projetos) {
		if (projetos.isEmpty()) {
			System.out.println("Nenhum projeto cadastrado.");
			return;
		}
		for (Projeto p : projetos) {
			System.out.println(p);
		}
	}
}