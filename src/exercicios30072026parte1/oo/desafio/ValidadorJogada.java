package exercicios30072026parte1.oo.desafio;

public class ValidadorJogada {

	public boolean validarPosicao(Tabuleiro tabuleiro, Posicao posicao) {

		return tabuleiro.estaLivre(posicao);

	}

	public boolean validar(Tabuleiro tabuleiro, Posicao posicao) {

		return validarPosicao(tabuleiro, posicao);

	}

}