package exercicios30072026parte1.oo.desafio;

public enum Simbolo {

	X('X'), 
	O('O');

	private final char valor;

	Simbolo(char valor) {
		this.valor = valor;
	}

	public char getValor() {
		return valor;
	}

}