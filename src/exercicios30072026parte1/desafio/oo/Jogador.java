package exercicios30072026parte1.desafio.oo;

public class Jogador {

	private final String nome;
	private final Simbolo simbolo;

	public Jogador(String nome, Simbolo simbolo) {
		this.nome = nome;
		this.simbolo = simbolo;
	}

	public String getNome() {
		return nome;
	}

	public Simbolo getSimbolo() {
		return simbolo;
	}

}