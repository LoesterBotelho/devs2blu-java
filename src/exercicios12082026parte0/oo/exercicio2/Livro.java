package exercicios12082026parte0.oo.exercicio2;

import java.util.Objects;

public class Livro {
	private static int contadorId = 1;
	private int id;
	private String titulo;
	private Autor autor;
	private Categoria categoria;

	public Livro() {
		this.id = contadorId++;
	}

	public Livro(String titulo, Autor autor, Categoria categoria) {
		this();
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
	}

	// Getters e Setters
	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + (autor != null ? autor.getNome() : "N/A")
				+ ", categoria=" + (categoria != null ? categoria.getNome() : "N/A") + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Livro))
			return false;
		Livro other = (Livro) obj;
		return id == other.id;
	}
}