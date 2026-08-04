package exercicios30072026parte1.oo.classes;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Funcionario {
	private String titulacao;
	private String areaPesquisa;
	private List<Disciplina> disciplinas;

	public Professor(String nome, String endereco, String telefone, String cpf, String numeroCtps, double salario,
			String titulacao, String areaPesquisa) {
		super(nome, endereco, telefone, cpf, numeroCtps, salario);
		this.titulacao = titulacao;
		this.areaPesquisa = areaPesquisa;
		this.disciplinas = new ArrayList<>();
	}

	public void ministrarDisciplina(Disciplina disciplina) {
		if (!disciplinas.contains(disciplina)) {
			disciplinas.add(disciplina);
			disciplina.setProfessor(this);
		}
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public String getAreaPesquisa() {
		return areaPesquisa;
	}

	public void setAreaPesquisa(String areaPesquisa) {
		this.areaPesquisa = areaPesquisa;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	@Override
	public String toString() {
		return "Professor [titulacao=" + titulacao + 
				", areaPesquisa=" + areaPesquisa + 
				", disciplinas=" + disciplinas
				+ "]";
	}

}