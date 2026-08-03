package pratica.orientacaoobjetos.ex01;

import java.util.List;

public class MainTestes {

	public static String titulo(int tamanho) {
		String marcador = "-";
		return marcador.repeat(tamanho);

	}
	
	public static String titulo(String texto, int tamanho) {
		String marcador = "-";

		int espacoRestante = tamanho - texto.length() - 2;

		if (espacoRestante < 0) {
			return texto;
		}

		int esquerda = espacoRestante / 2;
		int direita = espacoRestante - esquerda;

		return marcador.repeat(esquerda) + " " + texto + " " + marcador.repeat(direita);
	}
	
	public static void main(String[] args) {

		getAuthor();
		
		Curso curso = DadosAcademicos.criarCurso();
		Professor professor = DadosAcademicos.criarProfessor();
		TecnicoAdministrativo tecnico = DadosAcademicos.criarTecnicoAdministrativo();
		Aluno aluno = DadosAcademicos.criarAluno(curso);

		System.out.println( titulo("CURSO", 100) );
		System.out.println(curso);

		System.out.println();
		System.out.println( titulo("POLIMORFISMO", 100) );
		System.out.println( titulo("Aluno, Professor e Técnico são Pessoas", 100) );

		List<Pessoa> pessoas = List.of(aluno, professor, tecnico);

		for (Pessoa pessoa : pessoas) {
			System.out.println( titulo(100) );
			System.out.println("Classe real: " + pessoa.getClass().getSimpleName());
			System.out.println(pessoa);
		}

		System.out.println();
		System.out.println( titulo("TESTE ALUNO",100) );
		System.out.println("Classe: " + aluno.getClass().getSimpleName());
		System.out.println("Nome: " + aluno.getNome());
		System.out.println("Matrícula: " + aluno.getMatricula());
		System.out.println("Curso: " + aluno.getCurso().getNome());
		System.out.println("Quantidade disciplinas: " + aluno.getDisciplinas().size());

		System.out.println();
		System.out.println( titulo("TESTE PROFESSOR", 100) );
		System.out.println("Classe: " + professor.getClass().getSimpleName());
		System.out.println("Nome: " + professor.getNome());
		// campos herdados de Funcionario
		System.out.println("CTPS: " + professor.getCtps());
		System.out.println("Salário: " + professor.getSalario());
		// campos próprios de Professor
		System.out.println("Titulação: " + professor.getTitulacao());
		System.out.println("Área pesquisa: " + professor.getAreaPesquisa());
		System.out.println("Disciplinas ministradas: " + professor.getDisciplinas().size());

		System.out.println();
		System.out.println( titulo("TESTE TÉCNICO ADMINISTRATIVO", 100) );
		System.out.println("Classe: " + tecnico.getClass().getSimpleName());
		System.out.println("Nome: " + tecnico.getNome());
		// campos herdados de Funcionario
		System.out.println("CTPS: " + tecnico.getCtps());
		System.out.println("Salário: " + tecnico.getSalario());
		// campos próprios de Técnico
		System.out.println("Cargo: " + tecnico.getCargo());
		System.out.println("Departamento: " + tecnico.getDepartamento());



		System.out.println();
		System.out.println(titulo("TESTE HERANÇA", 100));
		System.out.println("Aluno é Pessoa? " + (aluno instanceof Pessoa));
		System.out.println("Professor é Pessoa? " + (professor instanceof Pessoa));
		System.out.println("Técnico é Pessoa? " + (tecnico instanceof Pessoa));
		System.out.println("Professor é Funcionario? " + (professor instanceof Funcionario));		
		System.out.println("Técnico é Funcionario? " + (tecnico instanceof Funcionario));
	}

	public static void getAuthor() {
		System.out.println(titulo(100));
		System.out.println("Author : Loester Botelho");	
		System.out.println(titulo(100));
		System.out.println();
	}

}
