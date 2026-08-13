package exercicios13082026parte0.oo.exercicio1;

import java.util.Objects;

public class Livro {

	private static int contadorId = 1;

	private int id;
	private String titulo;
	private String autor;
	private String isbn;
	private int qtdExemplares;

	public Livro() {
		this.id = contadorId++;
	}

	public Livro(String titulo, String autor, String isbn, int qtdExemplares) {
		this();
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.qtdExemplares = qtdExemplares;
	}

	public boolean temExemplarDisponivel() {
		return this.qtdExemplares > 0;
	}

	public void emprestarExemplar() {
		if (this.qtdExemplares > 0) {
			this.qtdExemplares--;
		}
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getQtdExemplares() {
		return qtdExemplares;
	}

	public void setQtdExemplares(int qtdExemplares) {
		this.qtdExemplares = qtdExemplares;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn
				+ ", exemplaresDisponiveis=" + qtdExemplares + "]";
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
		Livro other = (Livro) obj;
		return id == other.id;
	}
}