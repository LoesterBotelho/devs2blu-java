package exercicios13082026parte0.oo.exercicio2;

import java.util.Objects;

class Funcionario {
	private static int contadorId = 1;
	private int id;
	private String nome;

	public Funcionario() {
		this.id = contadorId++;
	}

	public Funcionario(String nome) {
		this();
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(id));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return id == other.id;
	}

}
