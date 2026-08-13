package exercicios12082026parte0.oo.exercicio2;

import java.util.Objects;

public class Categoria {
	private static int contadorId = 1;
	private int id;
	private String nome;

	public Categoria() {
		this.id = contadorId++;
	}

	public Categoria(String nome) {
		this();
		this.nome = nome;
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

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Categoria))
			return false;
		Categoria other = (Categoria) obj;
		return id == other.id;
	}
}