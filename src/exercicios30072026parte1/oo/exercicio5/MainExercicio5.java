package exercicios30072026parte1.oo.exercicio5;

import exercicios30072026parte1.oo.classes.Aluno;
import exercicios30072026parte1.oo.classes.Console;
import exercicios30072026parte1.oo.classes.Curso;
import exercicios30072026parte1.oo.classes.Disciplina;
import exercicios30072026parte1.oo.classes.Professor;

public class MainExercicio5 {
	public static void main(String[] args) {
		Console console = new Console();

		Curso cursoObj = new Curso("DEV01", "DEVS2BLU", 8);

		Professor profHeloisa = new Professor(
			"Heloisa Moura", "Rua 7 de Setembro, 1000", "(47) 99111-2233", 
			"123.456.789-00", "CTPS98765", 9200.00, 
			"Doutora", "Engenharia de Software e Qualidade"
		);

		Aluno aluno = new Aluno("Loester Botelho", "2026001", "333.444.555-66", cursoObj);
		
		Disciplina[] disciplinas = new Disciplina[] {
			new Disciplina("JAVA01", "Java", 60),
			new Disciplina("SPR02", "Spring", 40),
			new Disciplina("SQL03", "SQL", 40)
		};

		double[] notas = new double[3];
 
		for (int i = 0; i < disciplinas.length; i++) {
			profHeloisa.ministrarDisciplina(disciplinas[i]);
			aluno.matricularEmDisciplina(disciplinas[i]);
			
			notas[i] = (double) console.lerInteiro("Nota na disciplina " + disciplinas[i].getNome() + ": ");
		}

		console.imprimir("\n");
		console.imprimir(" RESULTADO FINAL ");
		console.imprimir("");
		console.imprimir("Professor  : " + profHeloisa.getNome());
		console.imprimir("Aluno      : " + aluno.getNome());
		console.imprimir("Matrícula  : " + aluno.getMatricula());
		console.imprimir("Curso      : " + aluno.getcurso().getNome());
		console.imprimir("");

		for (int i = 0; i < 3; i++) {
			boolean aprovado = notas[i] >= 6.0;
			String status = aprovado ? "Aprovado" : "Reprovado";

			console.imprimir(
					"[Disciplina=" + disciplinas[i].getNome() + 
					", Professor=" + disciplinas[i].getProfessor().getNome() +
					", Nota=" + notas[i] + 
					", Status=" + status + "]");
		}
		console.imprimir("");

		console.fechar();
	}
}