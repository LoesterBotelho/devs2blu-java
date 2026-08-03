package exercicios30072026parte1.desafio.oo;

public class Turno {

	private final Jogador jogador1;
	private final Jogador jogador2;

	private Jogador jogadorAtual;

	public Turno(Jogador jogador1, Jogador jogador2) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		this.jogadorAtual = jogador1;
	}

	public Jogador getJogadorAtual() {
		return jogadorAtual;
	}

	public void proximo() {

		if (jogadorAtual == jogador1) {
			jogadorAtual = jogador2;
		} else {
			jogadorAtual = jogador1;
		}

	}

}