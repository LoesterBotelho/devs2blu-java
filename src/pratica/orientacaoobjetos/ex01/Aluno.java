package pratica.orientacaoobjetos.ex01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aluno extends Pessoa implements Estudante {

	private final String matricula;

	private Curso curso;

	private final List<Disciplina> disciplinas;

	public Aluno(String nome, String cpf, LocalDate dataNascimento, Sexo sexo, Endereco endereco, String matricula,
			Curso curso) {

		super(nome, cpf, dataNascimento, sexo, endereco);

		this.matricula = validarCampo(matricula, "Matrícula");

		if (curso == null) {

			throw new IllegalArgumentException("Curso obrigatório");
		}

		this.curso = curso;

		this.disciplinas = new ArrayList<>();

	}

	@Override
	public void matricularDisciplina(Disciplina disciplina) {

		if (disciplina == null) {

			throw new IllegalArgumentException("Disciplina obrigatória");
		}

		if (!disciplinas.contains(disciplina)) {

			disciplinas.add(disciplina);

		}

	}

	@Override
	public void cancelarDisciplina(Disciplina disciplina) {

		if (disciplina == null) {

			throw new IllegalArgumentException("Disciplina obrigatória");
		}

		disciplinas.remove(disciplina);

	}

	public List<Disciplina> getDisciplinas() {

		return Collections.unmodifiableList(disciplinas);

	}

	public String getMatricula() {

		return matricula;

	}

	public Curso getCurso() {

		return curso;

	}

	public void alterarCurso(Curso curso) {

		if (curso == null) {

			throw new IllegalArgumentException("Curso obrigatório");

		}

		this.curso = curso;

	}

	private String validarCampo(String valor, String campo) {

		if (valor == null || valor.isBlank()) {

			throw new IllegalArgumentException(campo + " obrigatório");

		}

		return valor;

	}

}