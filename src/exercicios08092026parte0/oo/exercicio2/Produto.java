package exercicios08092026parte0.oo.exercicio2;

import java.util.Objects;

class Produto {
	private Long id;
	private String nome;
	private double preco;

	public Produto() {
	}

	public Produto(Long id, String nome, double preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Produto produto = (Produto) o;
		return Double.compare(produto.preco, preco) == 0 && Objects.equals(id, produto.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, preco);
	}

	@Override
	public String toString() {
		return "Produto{id=" + id + 
				", nome='" + nome + 
				"', preco=" + preco + 
				"}";
	}
}