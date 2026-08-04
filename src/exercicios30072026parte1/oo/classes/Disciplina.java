package exercicios30072026parte1.oo.classes;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
	private String codigo;
	private String nome;
	private int cargaHoraria;
	private Curso curso;
	private Professor professor;
	private List<Aluno> alunos;

	public Disciplina(String codigo, String nome, int cargaHoraria) {
		this.codigo = codigo;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.alunos = new ArrayList<>();
	}

	public void adicionarAluno(Aluno aluno) {
		if (!alunos.contains(aluno)) {
			alunos.add(aluno);
			aluno.getCursandoDisciplinas().add(this);
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

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	@Override
	public String toString() {
		return "Disciplina [codigo=" + codigo + 
				", nome=" + nome + 
				", cargaHoraria=" + cargaHoraria + 
				", curso=" + curso + 
				", professor=" + professor + 
				", alunos=" + alunos + "]";
	}

}