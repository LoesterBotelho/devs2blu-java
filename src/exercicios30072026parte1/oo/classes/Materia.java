package exercicios30072026parte1.oo.classes;

import java.util.ArrayList;

public class Materia {
	private Disciplina disciplina;
	private String nome;
	private ArrayList<Exercicio> listaExercicios;
	private String serie;
	private String bimestre;

	public Materia() {
		this.listaExercicios = new ArrayList<>();
	}

	public Materia(Disciplina disciplina, String nome, ArrayList<Exercicio> listaExercicios, String serie,
			String bimestre) {
		this.disciplina = disciplina;
		this.nome = nome;
		this.serie = serie;
		this.bimestre = bimestre;
		this.listaExercicios = (listaExercicios != null) ? listaExercicios : new ArrayList<>();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Exercicio> getListaExercicios() {
		return listaExercicios;
	}

	public void setListaExercicios(ArrayList<Exercicio> listaExercicios) {
		this.listaExercicios = listaExercicios;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getBimestre() {
		return bimestre;
	}

	public void setBimestre(String bimestre) {
		this.bimestre = bimestre;
	}

	@Override
	public String toString() {
		return "Materia [disciplina=" + disciplina + 
				", nome=" + nome + 
				", listaExercicios=" + listaExercicios +
				", serie=" + serie + 
				", bimestre=" + bimestre + 
				"]";
	}

}