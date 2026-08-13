package exercicios13082026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Projeto {
	private static int contadorId = 1;
	private int id;
	private String nome;
	private List<Tarefa> tarefas = new ArrayList<>();
	private Equipe equipe;

	public Projeto() {
		this.id = contadorId++;
	}

	public Projeto(String nome, Equipe equipe) {
		this();
		this.nome = nome;
		this.equipe = equipe;
	}

	public void adicionarTarefa(Tarefa t) {
		tarefas.add(t);
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

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	@Override
	public String toString() {
		return "Projeto [id=" + id + ", nome=" + nome + ", tarefas=" + tarefas + ", equipe=" + equipe + "]";
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
		Projeto other = (Projeto) obj;
		return id == other.id;
	}

}