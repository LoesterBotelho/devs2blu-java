package exercicios30072026parte1.exercicio02;

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
		System.out.println();		

		for (var i = 0; i < gramaticaBeatriz.getListaExercicios().size() - 1; i++) {
			System.out.println(gramaticaBeatriz.getListaExercicios().get(i));
		}
		
		System.out.println();
		System.out.println();
		
		for (var i = 0; i < matematicaBeatriz.getListaExercicios().size() - 1; i++) {
			System.out.println(matematicaBeatriz.getListaExercicios().get(i));
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("Sofia " + gramaticaSofia.getSerie() + " "+ gramaticaSofia.getBimestre());
		
		System.out.println();
		System.out.println();
		
		for (var i = 0; i < gramaticaSofia.getListaExercicios().size() - 1; i++) {
			System.out.println(gramaticaSofia.getListaExercicios().get(i));
		}
		
		System.out.println();
		System.out.println();
		
		for (var i = 0; i < matematicaSofia.getListaExercicios().size() - 1; i++) {
			System.out.println(matematicaSofia.getListaExercicios().get(i));
		}
		

	}
}
