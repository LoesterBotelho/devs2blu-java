package exercicios30072026parte1.oo.classes;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	private String nome;
	private String matricula;
	private String cpf;
	private Curso curso;
	private List<Disciplina> cursandoDisciplinas;

	public Aluno(String nome, String matricula, String cpf, Curso curso) {
		this.nome = nome;
		this.matricula = matricula;
		this.cpf = cpf;
		this.curso = curso;
		this.cursandoDisciplinas = new ArrayList<>();
	}

	public void matricularEmDisciplina(Disciplina disciplina) {
		if (!cursandoDisciplinas.contains(disciplina)) {
			cursandoDisciplinas.add(disciplina);
			disciplina.getAlunos().add(this);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Disciplina> getCursandoDisciplinas() {
		return cursandoDisciplinas;
	}

	public Curso getcurso() {
		return curso;
	}
	
	@Override
	public String toString() {
		return "Aluno [nome=" + nome + 
				", matricula=" + matricula + 
				", cpf=" + cpf + 
				", curso=" + curso
				+ ", cursandoDisciplinas=" + cursandoDisciplinas + 
				"]";
	}
	
	
}