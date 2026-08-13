package exercicios13082026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Equipe {
	private static int contadorId = 1;
	private int id;
	private String nome;
	private List<Funcionario> membros = new ArrayList<>();

	public Equipe() {
		this.id = contadorId++;
	}

	public Equipe(String nome) {
		this();
		this.nome = nome;
	}

	public void adicionarMembro(Funcionario f) {
		membros.add(f);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getMembros() {
		return membros;
	}

	public void setMembros(List<Funcionario> membros) {
		this.membros = membros;
	}

	@Override
	public String toString() {
		return "Equipe [id=" + id + ", nome=" + nome + ", membros=" + membros + "]";
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
		Equipe other = (Equipe) obj;
		return id == other.id;
	}

}
