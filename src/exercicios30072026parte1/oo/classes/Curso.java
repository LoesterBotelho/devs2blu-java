package exercicios30072026parte1.oo.classes;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	private String codigo;
	private String nome;
	private int duracao; // em semestres ou anos
	private List<Disciplina> disciplinas;

	public Curso(String codigo, String nome, int duracao) {
		this.codigo = codigo;
		this.nome = nome;
		this.duracao = duracao;
		this.disciplinas = new ArrayList<>();
	}

	public void adicionarDisciplina(Disciplina disciplina) {
		if (!disciplinas.contains(disciplina)) {
			disciplinas.add(disciplina);
			disciplina.setCurso(this);
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + 
				", nome=" + nome + 
				", duracao=" + duracao + 
				", disciplinas=" + disciplinas
				+ "]";
	}

}