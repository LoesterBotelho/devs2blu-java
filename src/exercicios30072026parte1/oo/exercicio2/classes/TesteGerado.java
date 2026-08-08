package exercicios30072026parte1.oo.exercicio2.classes;

import exercicios30072026parte1.oo.classes.Disciplina;
import exercicios30072026parte1.oo.classes.Exercicio;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class TesteGerado {
	private Disciplina disciplina;
	private Date dataGeracao;
	private ArrayList<Exercicio> questoesSelecionadas;

	public TesteGerado(Disciplina disciplina, ArrayList<Exercicio> bancoExercicios, int numDesejado) {
		this.disciplina = disciplina;
		this.dataGeracao = new Date();
		this.questoesSelecionadas = new ArrayList<>();


		ArrayList<Exercicio> copiaBanco = new ArrayList<>(bancoExercicios);		
		Collections.shuffle(copiaBanco);		
		int limite = Math.min(numDesejado, copiaBanco.size());
		for (int i = 0; i < limite; i++) {
			this.questoesSelecionadas.add(copiaBanco.get(i));
		}
	}

	public void exibirTeste() {
		System.out.println(" TESTE DE " + disciplina.getNome().toUpperCase() + " ");
		System.out.println("Data de Geração: " + dataGeracao);
		System.out.println("Número de Questões: " + questoesSelecionadas.size());
		System.out.println();

		int cont = 1;
		for (Exercicio ex : questoesSelecionadas) {
			System.out.println("Questão " + (cont++) + ": " + ex.getPergunta());
		}

		System.out.println("\n GABARITO ");
		cont = 1;
		for (Exercicio ex : questoesSelecionadas) {
			System.out.println("Q" + (cont++) + " -> " + ex.getResposta());
		}
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public Date getDataGeracao() {
		return dataGeracao;
	}

	public ArrayList<Exercicio> getQuestoesSelecionadas() {
		return questoesSelecionadas;
	}
}