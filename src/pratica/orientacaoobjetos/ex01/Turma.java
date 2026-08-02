package pratica.orientacaoobjetos.ex01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Turma {

	private final int codigo;

	private final Disciplina disciplina;

	private Professor professor;

	private final List<Aluno> alunos;

	public Turma(int codigo, Disciplina disciplina, Professor professor) {

		if (codigo <= 0) {
			throw new IllegalArgumentException("Código da turma inválido");
		}

		if (disciplina == null) {
			throw new IllegalArgumentException("Disciplina obrigatória");
		}

		if (professor == null) {
			throw new IllegalArgumentException("Professor obrigatório");
		}

		this.codigo = codigo;
		this.disciplina = disciplina;
		this.professor = professor;
		this.alunos = new ArrayList<>();
	}

	public void adicionarAluno(Aluno aluno) {

		if (aluno == null) {
			throw new IllegalArgumentException("Aluno obrigatório");
		}

		if (!alunos.contains(aluno)) {
			alunos.add(aluno);
		}
	}

	public void removerAluno(Aluno aluno) {

		alunos.remove(aluno);

	}

	public List<Aluno> getAlunos() {

		return Collections.unmodifiableList(alunos);

	}

	public int getCodigo() {

		return codigo;

	}

	public Disciplina getDisciplina() {

		return disciplina;

	}

	public Professor getProfessor() {

		return professor;

	}

	public void alterarProfessor(Professor professor) {

		if (professor == null) {
			throw new IllegalArgumentException("Professor obrigatório");
		}

		this.professor = professor;
	}
}