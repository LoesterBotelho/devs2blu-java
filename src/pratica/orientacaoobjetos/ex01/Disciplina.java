package pratica.orientacaoobjetos.ex01;

public class Disciplina {

	private final String codigo;

	private String nome;

	private int cargaHoraria;

	private Curso curso;

	private Professor professor;

	public Disciplina(String codigo, String nome, int cargaHoraria) {

		this.codigo = validarCampo(codigo, "Código");

		this.nome = validarCampo(nome, "Nome");

		if (cargaHoraria <= 0) {
			throw new IllegalArgumentException("Carga horária inválida");
		}

		this.cargaHoraria = cargaHoraria;
	}

	public void definirProfessor(Professor professor) {

		if (professor == null) {
			throw new IllegalArgumentException("Professor obrigatório");
		}

		this.professor = professor;

	}

	public void definirCurso(Curso curso) {

		if (curso == null) {
			throw new IllegalArgumentException("Curso obrigatório");
		}

		this.curso = curso;

	}

	public String getCodigo() {

		return codigo;

	}

	public String getNome() {

		return nome;

	}

	public int getCargaHoraria() {

		return cargaHoraria;

	}

	public Curso getCurso() {

		return curso;

	}

	public Professor getProfessor() {

		return professor;

	}

	private String validarCampo(String valor, String campo) {

		if (valor == null || valor.isBlank()) {

			throw new IllegalArgumentException(campo + " obrigatório");
		}

		return valor;
	}
}