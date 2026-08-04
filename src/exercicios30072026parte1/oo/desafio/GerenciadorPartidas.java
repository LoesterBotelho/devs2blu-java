package exercicios30072026parte1.oo.desafio;

import exercicios30072026parte1.oo.classes.Console;

public class GerenciadorPartidas {

	private final Console console;

	public GerenciadorPartidas() {

		this.console = new Console();

	}

	public void iniciar() {

		int opcao;

		do {

			console.imprimir("------- NOVA PARTIDA -------");
			Jogador jogador1 = criarJogador("Nome jogador 1:", Simbolo.X);
			Jogador jogador2 = criarJogador("Nome jogador 2:", Simbolo.O);
			JogoDaVelha jogo = criarJogo(jogador1, jogador2);

			jogo.iniciar();

			opcao = console.lerInteiro("Deseja jogar novamente?\n1 - Sim\n0 - Não");

		} while (opcao != 0);

		console.imprimir("Obrigado por jogar!");

		console.fechar();

	}

	private Jogador criarJogador(String mensagem, Simbolo simbolo) {

		String nome = console.lerTexto(mensagem);

		return new Jogador(nome, simbolo);

	}

	private JogoDaVelha criarJogo(Jogador jogador1, Jogador jogador2) {

		return new JogoDaVelha(
				new Tabuleiro(), 
				new Turno(jogador1, jogador2), 
				console
				);

	}

}