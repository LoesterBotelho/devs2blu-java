package exercicios30072026parte1.oo.desafio;

public class Tabuleiro {

	private final char[][] casas = new char[3][3];

	public Tabuleiro() {

		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				casas[linha][coluna] = ' ';
			}
		}
	}
	
	public char get(Posicao posicao) {
		return casas[posicao.getLinha()][posicao.getColuna()];
	}

	public void set(Posicao posicao, char simbolo) {
		casas[posicao.getLinha()][posicao.getColuna()] = simbolo;
	}

	public boolean estaLivre(Posicao posicao) {
		return get(posicao) == ' ';
	}

}