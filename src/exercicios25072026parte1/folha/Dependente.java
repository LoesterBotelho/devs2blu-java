package exercicios25072026parte1.folha;

public class Dependente {

	private String nome;
	private String grauParentesco;

	public Dependente(String nome, String grauParentesco) {

		this.nome = nome;
		this.grauParentesco = grauParentesco;

	}

	public String getNome() {

		return nome;

	}

	public String getGrauParentesco() {

		return grauParentesco;

	}

	public void imprimir() {

		System.out.println(nome + " - " + grauParentesco);

	}

}