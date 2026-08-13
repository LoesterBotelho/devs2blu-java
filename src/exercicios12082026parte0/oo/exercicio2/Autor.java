package exercicios12082026parte0.oo.exercicio2;

import java.util.Objects;

public class Autor {
	private static int contadorId = 1;
	private int id;
	private String nome;
	private String nacionalidade;

	public Autor() {
		this.id = contadorId++;
	}

	public Autor(String nome, String nacionalidade) {
		this();
		this.nome = nome;
		this.nacionalidade = nacionalidade;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", nacionalidade=" + nacionalidade + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Autor))
			return false;
		Autor other = (Autor) obj;
		return id == other.id;
	}
}