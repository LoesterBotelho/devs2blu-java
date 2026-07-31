package exercicios30072026parte1.exercicio02;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

		Disciplina portugues = new Disciplina("Português");
		Disciplina matematica = new Disciplina("Matemática");

		Materia gramaticaBeatriz = new Materia(portugues, "Gramática",
				CadastrarExercicios.carregarListaPortugues1Serie(), "1º Serie", "1º Bimestre");

		Materia matematicaBeatriz = new Materia(matematica, "Gramática",
				CadastrarExercicios.carregarListaMatematicaAdicao1Serie(), "1º Serie", "1º Bimestre");

		Materia gramaticaSofia = new Materia(portugues, "Gramática", CadastrarExercicios.carregarListaPortugues2Serie(),
				"2º Serie", "1º Bimestre");

		Materia matematicaSofia = new Materia(matematica, "Gramática",
				CadastrarExercicios.carregarListaMatematicaAdicao1Serie(), "1º Serie", "1º Bimestre");

		System.out.println("Beatriz " + gramaticaBeatriz.getSerie() + " "+ gramaticaBeatriz.getBimestre());

		System.out.println();

		for (var i = 0; i < gramaticaBeatriz.getListaExercicios().size() - 1; i++) {
			System.out.println(gramaticaBeatriz.getListaExercicios());
		}

	}
}
