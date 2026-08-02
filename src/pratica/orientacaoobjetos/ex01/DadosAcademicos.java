package pratica.orientacaoobjetos.ex01;

import java.time.LocalDate;

public class DadosAcademicos {

	public static Curso criarCurso() {

		Curso curso = new Curso("CC001", "Ciência da Computação", 8);

		Disciplina poo = new Disciplina("DISC001", "Programação Orientada a Objetos", 80);

		Disciplina banco = new Disciplina("DISC002", "Banco de Dados", 60);

		curso.adicionarDisciplina(poo);
		curso.adicionarDisciplina(banco);

		return curso;
	}

	public static Professor criarProfessor() {

		Endereco endereco = new Endereco("Rua XV de Novembro", "500", "Centro", "Blumenau", "SC", "89000-000");

		Professor professor = new Professor("Carlos Silva", "12345678900", LocalDate.of(1980, 5, 10), Sexo.MASCULINO,
				endereco, "CTPS12345", 8000, "Doutor", "Computação");

		return professor;
	}

	public static TecnicoAdministrativo criarTecnicoAdministrativo() {

		Endereco endereco = new Endereco("Rua das Palmeiras", "200", "Velha", "Blumenau", "SC", "89030-000");

		TecnicoAdministrativo tecnico = new TecnicoAdministrativo("Pedro Santos", "33333333333",
				LocalDate.of(1990, 2, 10), Sexo.MASCULINO, endereco, "CTPS99999", 4500, "Analista Administrativo",
				"Secretaria Acadêmica");

		return tecnico;
	}

	public static Aluno criarAluno(Curso curso) {

		Endereco endereco = new Endereco("Rua das Flores", "100", "Centro", "Blumenau", "SC", "89000-000");

		Aluno aluno = new Aluno("João Souza", "11111111111", LocalDate.of(2000, 3, 15), Sexo.MASCULINO, endereco,
				"20260001", curso);

		return aluno;
	}

}