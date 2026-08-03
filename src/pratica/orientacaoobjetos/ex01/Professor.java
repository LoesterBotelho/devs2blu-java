package pratica.orientacaoobjetos.ex01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Professor extends Funcionario {

	private String titulacao;

	private String areaPesquisa;

	private final List<Disciplina> disciplinas;

	public Professor(String nome, String cpf, LocalDate dataNascimento, Sexo sexo, Endereco endereco, String ctps,
			double salario, String titulacao, String areaPesquisa) {

		super(nome, cpf, dataNascimento, sexo, endereco, ctps, salario);

		this.titulacao = validarCampo(titulacao, "Titulação");

		this.areaPesquisa = validarCampo(areaPesquisa, "Área de pesquisa");

		this.disciplinas = new ArrayList<>();

	}

	public void ministrarDisciplina(Disciplina disciplina) {

		if (disciplina == null) {

			throw new IllegalArgumentException("Disciplina obrigatória");
		}

		if (!disciplinas.contains(disciplina)) {

			disciplinas.add(disciplina);

		}
	}

	public void removerDisciplina(Disciplina disciplina) {

		if (disciplina == null) {

			throw new IllegalArgumentException("Disciplina obrigatória");
		}

		disciplinas.remove(disciplina);

	}

	public List<Disciplina> getDisciplinas() {

		return Collections.unmodifiableList(disciplinas);

	}

	public String getTitulacao() {

		return titulacao;

	}

	public String getAreaPesquisa() {

		return areaPesquisa;

	}

	private String validarCampo(String valor, String campo) {

		if (valor == null || valor.isBlank()) {

			throw new IllegalArgumentException(campo + " obrigatório");

		}

		return valor;

	}

}