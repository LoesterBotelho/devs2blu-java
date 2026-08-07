package exercicios30072026parte1.oo.exercicio2;

import exercicios30072026parte1.oo.classes.Disciplina;
import exercicios30072026parte1.oo.classes.Materia;
import exercicios30072026parte1.oo.exercicio2.classes.CadastrarExercicios;
import exercicios30072026parte1.oo.exercicio2.classes.TesteGerado;

public class MainExercicio2 {
	public static void main(String[] args) {

		Disciplina portugues = new Disciplina("DISC01", "Português", 60);
		Disciplina matematica = new Disciplina("DISC02", "Matemática", 60);

		Materia gramaticaBeatriz = new Materia(portugues, "Gramática",
				CadastrarExercicios.carregarListaPortugues1Serie(), "1º Serie", "1º Bimestre");

		Materia matematicaBeatriz = new Materia(matematica, "Matemática",
				CadastrarExercicios.carregarListaMatematicaAdicao1Serie(), "1º Serie", "1º Bimestre");

		Materia gramaticaSofia = new Materia(portugues, "Gramática", CadastrarExercicios.carregarListaPortugues2Serie(),
				"2º Serie", "1º Bimestre");

		Materia matematicaSofia = new Materia(matematica, "Matemática",
				CadastrarExercicios.carregarListaMatematicaAdicao1Serie(), "1º Serie", "1º Bimestre");

		System.out.println("Beatriz " + gramaticaBeatriz.getSerie() + " "+ gramaticaBeatriz.getBimestre());

		System.out.println();
		System.out.println();		

//		for (var i = 0; i < gramaticaBeatriz.getListaExercicios().size() - 1; i++) {
//			System.out.println(gramaticaBeatriz.getListaExercicios().get(i));
//		}
//		
//		System.out.println();
//		System.out.println();
//		
//		for (var i = 0; i < matematicaBeatriz.getListaExercicios().size() - 1; i++) {
//			System.out.println(matematicaBeatriz.getListaExercicios().get(i));
//		}
//		
//		System.out.println();
//		System.out.println();
//		
//		System.out.println("Sofia " + gramaticaSofia.getSerie() + " "+ gramaticaSofia.getBimestre());
//		
//		System.out.println();
//		System.out.println();
//		
//		for (var i = 0; i < gramaticaSofia.getListaExercicios().size() - 1; i++) {
//			System.out.println(gramaticaSofia.getListaExercicios().get(i));
//		}
//		
//		System.out.println();
//		System.out.println();
//		
//		for (var i = 0; i < matematicaSofia.getListaExercicios().size() - 1; i++) {
//			System.out.println(matematicaSofia.getListaExercicios().get(i));
//		}
		
		System.out.println();
		System.out.println();		

        int quantidadeDesejada = 5;

        TesteGerado meuTeste1 = new TesteGerado(portugues, CadastrarExercicios.carregarListaPortugues1Serie(), quantidadeDesejada);
        meuTeste1.exibirTeste();
        
        TesteGerado meuTeste2 = new TesteGerado(matematica, CadastrarExercicios.carregarListaMatematicaAdicao1Serie(), quantidadeDesejada);
        meuTeste2.exibirTeste();
        
        TesteGerado meuTeste3 = new TesteGerado(matematica, CadastrarExercicios.carregarListaMatematicaAdicao1Serie(), quantidadeDesejada);
        meuTeste3.exibirTeste();
        
        TesteGerado meuTeste4 = new TesteGerado(portugues, CadastrarExercicios.carregarListaPortugues1Serie(), quantidadeDesejada);
        meuTeste4.exibirTeste();        
        
	}
}