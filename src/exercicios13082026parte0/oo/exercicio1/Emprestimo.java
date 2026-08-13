package exercicios13082026parte0.oo.exercicio1;

import java.util.Objects;

public class Emprestimo {

	private static int contadorId = 1;

	private int id;
	private String dataEmprestimo;
	private String dataDevolucao;
	private Leitor leitor;
	private Livro livro;

	public Emprestimo() {
		this.id = contadorId++;
	}

	public Emprestimo(String dataEmprestimo, String dataDevolucao, Leitor leitor, Livro livro) {
		this();
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.leitor = leitor;
		this.livro = livro;
	}

	public int getId() {
		return id;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Leitor getLeitor() {
		return leitor;
	}

	public void setLeitor(Leitor leitor) {
		this.leitor = leitor;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	@Override
	public String toString() {
		return "Emprestimo [id=" + id + ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao=" + dataDevolucao
				+ ", leitor=" + (leitor != null ? leitor.getNome() : "Não informado") + ", livro="
				+ (livro != null ? livro.getTitulo() : "Não informado") + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		return id == other.id;
	}
}