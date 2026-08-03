package exercicios30072026parte1.desafio.oo;

public class JogoDaVelha {

	private final Tabuleiro tabuleiro;
	private final Turno turno;
	private final Console console;

	private final ValidadorJogada validadorJogada;
	private final ValidadorVitoria validadorVitoria;
	private final ValidadorEmpate validadorEmpate;

	private ResultadoPartida resultado;

	private Jogador vencedor;

	public JogoDaVelha(Tabuleiro tabuleiro, Turno turno, Console console) {

		this.tabuleiro = tabuleiro;
		this.turno = turno;
		this.console = console;

		this.validadorJogada = new ValidadorJogada();
		this.validadorVitoria = new ValidadorVitoria();
		this.validadorEmpate = new ValidadorEmpate();

		this.resultado = ResultadoPartida.EM_ANDAMENTO;

	}

	public void iniciar() {

		console.imprimir("------- JOGO DA VELHA -------");

		while (resultado == ResultadoPartida.EM_ANDAMENTO) {

			executarRodada();

		}

		encerrar();

	}

	private void executarRodada() {

		Jogador jogadorAtual = turno.getJogadorAtual();

		console.imprimir("Vez do jogador: " + jogadorAtual.getNome());

		Posicao posicao = lerPosicao();

		if (!validadorJogada.validar(tabuleiro, posicao)) {

			console.imprimir("Posição inválida!");

			return;

		}

		tabuleiro.set(posicao, jogadorAtual.getSimbolo().getValor());

		imprimirTabuleiro();

		verificarResultado(jogadorAtual);

		if (resultado == ResultadoPartida.EM_ANDAMENTO) {

			turno.proximo();

		}

	}

	private Posicao lerPosicao() {

		int linha = console.lerInteiro("Digite a linha (1-3) (vertical/em pé):");

		int coluna = console.lerInteiro("Digite a coluna (1-3) (horizontal/deitado):");

	    return new Posicao(linha - 1, coluna - 1);

	}
	private void verificarResultado(Jogador jogadorAtual) {

		if (validadorVitoria.validar(tabuleiro, jogadorAtual.getSimbolo().getValor())) {

			vencedor = jogadorAtual;

			resultado = ResultadoPartida.VITORIA;

			return;

		}

		if (validadorEmpate.validar(tabuleiro)) {

			resultado = ResultadoPartida.EMPATE;

		}

	}

	private void encerrar() {

		console.imprimir("");

		if (resultado == ResultadoPartida.VITORIA) {

			console.imprimir("Parabéns " + vencedor.getNome() + "! Você ganhou a partida.");

		} else if (resultado == ResultadoPartida.EMPATE) {

			console.imprimir("Ninguém ganhou. A partida terminou empatada.");

		}

	}

	private void imprimirTabuleiro() {

		console.imprimir("");

		for (int linha = 0; linha < 3; linha++) {

			StringBuilder linhaTabuleiro = new StringBuilder();

			for (int coluna = 0; coluna < 3; coluna++) {

				char valor = tabuleiro.get(new Posicao(linha, coluna));

				linhaTabuleiro.append(" ").append(valor).append(" ");

				if (coluna < 2) {

					linhaTabuleiro.append("|");

				}

			}

			console.imprimir(linhaTabuleiro.toString());

			if (linha < 2) {
				console.imprimir("---+---+---");
			}

		}

	}

}