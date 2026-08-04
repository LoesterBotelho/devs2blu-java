package exercicios30072026parte1.oo.exercicio2.classes;

import java.util.ArrayList;
import java.util.Arrays;

import exercicios30072026parte1.oo.classes.Exercicio;

public class CadastrarExercicios {

	public static ArrayList<Exercicio> carregarListaMatematicaAdicao1Serie() {
		Exercicio ex01 = new Exercicio("Quanto é 1+1 ?", "R: 2");
		Exercicio ex02 = new Exercicio("Quanto é 1+2 ?", "R: 3");
		Exercicio ex03 = new Exercicio("Quanto é 2+2 ?", "R: 4");
		Exercicio ex04 = new Exercicio("Quanto é 2+3 ?", "R: 5");
		Exercicio ex05 = new Exercicio("Quanto é 3+3 ?", "R: 6");
		Exercicio ex06 = new Exercicio("Quanto é 3+4 ?", "R: 7");
		Exercicio ex07 = new Exercicio("Quanto é 4+4 ?", "R: 8");
		Exercicio ex08 = new Exercicio("Quanto é 4+5 ?", "R: 9");
		Exercicio ex09 = new Exercicio("Quanto é 5+5 ?", "R: 10");
		Exercicio ex10 = new Exercicio("Quanto é 5+6 ?", "R: 11");
		Exercicio ex11 = new Exercicio("Quanto é 6+6 ?", "R: 12");
		Exercicio ex12 = new Exercicio("Quanto é 6+7 ?", "R: 13");
		Exercicio ex13 = new Exercicio("Quanto é 7+7 ?", "R: 14");
		Exercicio ex14 = new Exercicio("Quanto é 7+8 ?", "R: 15");
		Exercicio ex15 = new Exercicio("Quanto é 8+8 ?", "R: 16");
		Exercicio ex16 = new Exercicio("Quanto é 8+9 ?", "R: 17");
		Exercicio ex17 = new Exercicio("Quanto é 9+9 ?", "R: 18");
		Exercicio ex18 = new Exercicio("Quanto é 9+10 ?", "R: 19");
		Exercicio ex19 = new Exercicio("Quanto é 10+10 ?", "R: 20");
		Exercicio ex20 = new Exercicio("Quanto é 10+11 ?", "R: 21");

		ArrayList<Exercicio> lista = new ArrayList<>(Arrays.asList(ex01, ex02, ex03, ex04, ex05, ex06, ex07, ex08, ex09,
				ex10, ex11, ex12, ex13, ex14, ex15, ex16, ex17, ex18, ex19, ex20));

		return lista;
	}

	public static ArrayList<Exercicio> carregarListaMatematicaAdicao2Serie() {
		Exercicio ex01 = new Exercicio("Quanto é 12+15 ?", "R: 27");
		Exercicio ex02 = new Exercicio("Quanto é 18+11 ?", "R: 29");
		Exercicio ex03 = new Exercicio("Quanto é 23+14 ?", "R: 37");
		Exercicio ex04 = new Exercicio("Quanto é 17+22 ?", "R: 39");
		Exercicio ex05 = new Exercicio("Quanto é 25+13 ?", "R: 38");
		Exercicio ex06 = new Exercicio("Quanto é 19+18 ?", "R: 37");
		Exercicio ex07 = new Exercicio("Quanto é 24+16 ?", "R: 40");
		Exercicio ex08 = new Exercicio("Quanto é 21+22 ?", "R: 43");
		Exercicio ex09 = new Exercicio("Quanto é 26+17 ?", "R: 43");
		Exercicio ex10 = new Exercicio("Quanto é 28+15 ?", "R: 43");
		Exercicio ex11 = new Exercicio("Quanto é 31+12 ?", "R: 43");
		Exercicio ex12 = new Exercicio("Quanto é 22+23 ?", "R: 45");
		Exercicio ex13 = new Exercicio("Quanto é 34+11 ?", "R: 45");
		Exercicio ex14 = new Exercicio("Quanto é 27+19 ?", "R: 46");
		Exercicio ex15 = new Exercicio("Quanto é 35+12 ?", "R: 47");
		Exercicio ex16 = new Exercicio("Quanto é 29+19 ?", "R: 48");
		Exercicio ex17 = new Exercicio("Quanto é 33+16 ?", "R: 49");
		Exercicio ex18 = new Exercicio("Quanto é 25+25 ?", "R: 50");
		Exercicio ex19 = new Exercicio("Quanto é 38+12 ?", "R: 50");
		Exercicio ex20 = new Exercicio("Quanto é 27+24 ?", "R: 51");

		ArrayList<Exercicio> lista = new ArrayList<>(Arrays.asList(ex01, ex02, ex03, ex04, ex05, ex06, ex07, ex08, ex09,
				ex10, ex11, ex12, ex13, ex14, ex15, ex16, ex17, ex18, ex19, ex20));

		return lista;
	}

	public static ArrayList<Exercicio> carregarListaPortugues1Serie() {
		Exercicio ex01 = new Exercicio("Qual é a primeira letra da palavra CASA?", "R: C");
		Exercicio ex02 = new Exercicio("Quantas letras tem a palavra SOL?", "R: 3");
		Exercicio ex03 = new Exercicio("Complete: B _ L A", "R: O");
		Exercicio ex04 = new Exercicio("Qual é a última letra da palavra GATO?", "R: O");
		Exercicio ex05 = new Exercicio("Qual destas é uma vogal? A, B ou C", "R: A");
		Exercicio ex06 = new Exercicio("Quantas sílabas tem a palavra BOLA?", "R: 2");
		Exercicio ex07 = new Exercicio("Complete: C A _ A", "R: S");
		Exercicio ex08 = new Exercicio("Qual destas palavras é um animal? GATO ou MESA", "R: GATO");
		Exercicio ex09 = new Exercicio("Qual letra vem depois do A?", "R: B");
		Exercicio ex10 = new Exercicio("Qual letra vem antes do D?", "R: C");
		Exercicio ex11 = new Exercicio("Complete: P A T _", "R: O");
		Exercicio ex12 = new Exercicio("Quantas letras tem a palavra BOLA?", "R: 4");
		Exercicio ex13 = new Exercicio("Qual é a primeira letra da palavra SAPO?", "R: S");
		Exercicio ex14 = new Exercicio("Qual destas é uma consoante? B ou A", "R: B");
		Exercicio ex15 = new Exercicio("Complete: M _ S A", "R: E");
		Exercicio ex16 = new Exercicio("Qual é a última letra da palavra PATO?", "R: O");
		Exercicio ex17 = new Exercicio("Quantas sílabas tem a palavra CASA?", "R: 2");
		Exercicio ex18 = new Exercicio("Complete: J A N _ L A", "R: E");
		Exercicio ex19 = new Exercicio("Qual destas palavras é uma fruta? MAÇÃ ou SAPATO", "R: MAÇÃ");
		Exercicio ex20 = new Exercicio("Qual letra inicia a palavra ESCOLA?", "R: E");

		return new ArrayList<>(Arrays.asList(ex01, ex02, ex03, ex04, ex05, ex06, ex07, ex08, ex09, ex10, ex11, ex12,
				ex13, ex14, ex15, ex16, ex17, ex18, ex19, ex20));
	}

	public static ArrayList<Exercicio> carregarListaPortugues2Serie() {
		Exercicio ex01 = new Exercicio("Qual é o plural de CASA?", "R: CASAS");
		Exercicio ex02 = new Exercicio("Separe em sílabas: BOLA", "R: BO-LA");
		Exercicio ex03 = new Exercicio("Qual é o antônimo de ALTO?", "R: BAIXO");
		Exercicio ex04 = new Exercicio("Qual é o plural de GATO?", "R: GATOS");
		Exercicio ex05 = new Exercicio("Separe em sílabas: SAPATO", "R: SA-PA-TO");
		Exercicio ex06 = new Exercicio("Qual é o diminutivo de CASA?", "R: CASINHA");
		Exercicio ex07 = new Exercicio("Qual é o aumentativo de CASA?", "R: CASARÃO");
		Exercicio ex08 = new Exercicio("Qual é o contrário de FELIZ?", "R: TRISTE");
		Exercicio ex09 = new Exercicio("Complete: O MENINO ESTÁ _ _ _ Z", "R: FELIZ");
		Exercicio ex10 = new Exercicio("Qual é o plural de FLOR?", "R: FLORES");
		Exercicio ex11 = new Exercicio("Separe em sílabas: ESCOLA", "R: ES-CO-LA");
		Exercicio ex12 = new Exercicio("Qual é o contrário de CLARO?", "R: ESCURO");
		Exercicio ex13 = new Exercicio("Qual é o plural de LIVRO?", "R: LIVROS");
		Exercicio ex14 = new Exercicio("Separe em sílabas: JANELA", "R: JA-NE-LA");
		Exercicio ex15 = new Exercicio("Qual é o feminino de MENINO?", "R: MENINA");
		Exercicio ex16 = new Exercicio("Qual é o masculino de MENINA?", "R: MENINO");
		Exercicio ex17 = new Exercicio("Qual é o plural de PAPEL?", "R: PAPÉIS");
		Exercicio ex18 = new Exercicio("Qual é o contrário de QUENTE?", "R: FRIO");
		Exercicio ex19 = new Exercicio("Separe em sílabas: CADERNO", "R: CA-DER-NO");
		Exercicio ex20 = new Exercicio("Qual é o plural de ÁRVORE?", "R: ÁRVORES");

		return new ArrayList<>(Arrays.asList(ex01, ex02, ex03, ex04, ex05, ex06, ex07, ex08, ex09, ex10, ex11, ex12,
				ex13, ex14, ex15, ex16, ex17, ex18, ex19, ex20));
	}

}
