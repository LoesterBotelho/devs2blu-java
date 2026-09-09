package exercicios08092026parte0.oo.exercicio2;

import java.util.Objects;

class Roupa extends Produto {
	private String tamanho;

	public Roupa() {
		super();
	}

	public Roupa(Long id, String nome, double preco, String tamanho) {
		super(id, nome, preco);
		this.tamanho = tamanho;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	@Override
	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;
		Roupa roupa = (Roupa) o;
		return Objects.equals(tamanho, roupa.tamanho);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), tamanho);
	}

	@Override
	public String toString() {
		return "Roupa{id=" + getId() + 
				", nome='" + getNome() + 
				"', preco=" + getPreco() + 
				", tamanho='" + tamanho
				+ "'}";
	}
}