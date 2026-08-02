package exercicios30072026parte1.desafio.oo;

public class ValidadorEmpate {

	public boolean validar(Tabuleiro tabuleiro) {

		for (int linha = 0; linha < 3; linha++) {

			for (int coluna = 0; coluna < 3; coluna++) {

				Posicao posicao = new Posicao(linha, coluna);

				if (tabuleiro.estaLivre(posicao)) {

					return false;

				}

			}

		}

		return true;

	}

}