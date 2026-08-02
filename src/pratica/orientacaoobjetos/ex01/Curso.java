package pratica.orientacaoobjetos.ex01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Curso {

	private final String codigo;

	private String nome;

	private int duracaoSemestres;

	private final List<Disciplina> disciplinas;

	private final List<Aluno> alunos;

	public Curso(String codigo, String nome, int duracaoSemestres) {

		this.codigo = validarCampo(codigo, "Código");
		this.nome = validarCampo(nome, "Nome");

		if (duracaoSemestres <= 0) {
			throw new IllegalArgumentException("Duração inválida");
		}

		this.duracaoSemestres = duracaoSemestres;

		this.disciplinas = new ArrayList<>();

		this.alunos = new ArrayList<>();
	}

	public void adicionarDisciplina(Disciplina disciplina) {

		if (disciplina == null) {
			throw new IllegalArgumentException("Disciplina obrigatória");
		}

		if (!disciplinas.contains(disciplina)) {
			disciplinas.add(disciplina);
		}
	}

	public void matricularAluno(Aluno aluno) {

		if (aluno == null) {
			throw new IllegalArgumentException("Aluno obrigatório");
		}

		if (!alunos.contains(aluno)) {
			alunos.add(aluno);
		}
	}

	public List<Disciplina> getDisciplinas() {

		return Collections.unmodifiableList(disciplinas);

	}

	public List<Aluno> getAlunos() {

		return Collections.unmodifiableList(alunos);

	}

	public String getCodigo() {

		return codigo;

	}

	public String getNome() {

		return nome;

	}

	public int getDuracaoSemestres() {

		return duracaoSemestres;

	}

	private String validarCampo(String valor, String campo) {

		if (valor == null || valor.isBlank()) {

			throw new IllegalArgumentException(campo + " obrigatório");
		}

		return valor;
	}

	@Override
	public String toString() {

		return """
				Curso:
				Código: %s
				Nome: %s
				Duração: %d semestres
				Quantidade de disciplinas: %d
				Quantidade de alunos: %d
				""".formatted(codigo, nome, duracaoSemestres, disciplinas.size(), alunos.size());
	}

}