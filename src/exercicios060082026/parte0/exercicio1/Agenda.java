package exercicios060082026.parte0.exercicio1;

import java.util.List;

public class Agenda {
	private String nome;
	private List<Contato> contatos;

	public Agenda() {
	}

	public Agenda(String nome, List<Contato> contatos) {
		super();
		this.nome = nome;
		this.contatos = contatos;
	}

	@Override
	public String toString() {
		return "Agenda [nome=" + nome + 
				", contatos=" + contatos + 
				"]";
	}

}
