package exercicios30072026parte1.oo.exercicio1;

import exercicios30072026parte1.oo.classes.Aluno;
import exercicios30072026parte1.oo.classes.Curso;
import exercicios30072026parte1.oo.classes.Disciplina;
import exercicios30072026parte1.oo.classes.Professor;
import exercicios30072026parte1.oo.classes.TecnicoAdministrativo;

public class MainExercicio1 {
	public static void main(String[] args) {

		Curso devs2blu = new Curso("DEV01", "DEVS2BLU", 8);

		Professor profHeloisa = new Professor("Heloisa Moura", "Rua 7 de Setembro, 1000", "(47) 99111-2233", "123.456.789-00",
				"CTPS98765", 9200.00, "Doutora", "Engenharia de Software e Qualidade");

		TecnicoAdministrativo tecAna = new TecnicoAdministrativo("Ana Souza", "Av. Beira Rio, 456", "(47) 98888-2222",
				"222.333.444-55", "CTPS54321", 4200.00, "Assistente Administrativo", "Secretaria Acadêmica");

		Disciplina poo = new Disciplina("CC101", "Programação Orientada a Objetos", 80);
		devs2blu.adicionarDisciplina(poo);

		profHeloisa.ministrarDisciplina(poo);

		Aluno alunoLoester = new Aluno("Loester Botelho", "2026001", "333.444.555-66", devs2blu);

		alunoLoester.matricularEmDisciplina(poo);

		System.out.println(" SISTEMA DE CONTROLE ESCOLAR - v1.0 ");
		System.out.println("Curso: " + devs2blu.getNome() + " (Duração: " + devs2blu.getDuracao() + " semestres)");

		System.out.println("\n Professor ");
		System.out.println("Nome: " + profHeloisa.getNome());
		System.out.println("Titulação: " + profHeloisa.getTitulacao());
		System.out.println("Área de Pesquisa: " + profHeloisa.getAreaPesquisa());
		System.out.println("Salário: R$ " + profHeloisa.getSalario());

		System.out.println("\n Técnico Administrativo ");
		System.out.println("Nome: " + tecAna.getNome());
		System.out.println("Cargo: " + tecAna.getCargo());
		System.out.println("Departamento: " + tecAna.getDepartamento());

		System.out.println("\n Disciplinas do Curso ");
		for (Disciplina d : devs2blu.getDisciplinas()) {
			System.out.println("Disciplina: " + d.getNome() + " | Carga Horária: " + d.getCargaHoraria() + "h");
			System.out.println("Professor Responsável: " + d.getProfessor().getNome());

			System.out.println("Alunos Matriculados:");
			for (Aluno a : d.getAlunos()) {
				System.out.println(" - " + a.getNome() + " (Matrícula: " + a.getMatricula() + ")");
			}
		}
	}
}