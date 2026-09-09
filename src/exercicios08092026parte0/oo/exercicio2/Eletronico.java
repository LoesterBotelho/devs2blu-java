package exercicios08092026parte0.oo.exercicio2;

import java.util.Objects;

class Eletronico extends Produto {
	private int garantiaMeses;

	public Eletronico() {
		super();
	}

	public Eletronico(Long id, String nome, double preco, int garantiaMeses) {
		super(id, nome, preco);
		this.garantiaMeses = garantiaMeses;
	}

	public int getGarantiaMeses() {
		return garantiaMeses;
	}

	public void setGarantiaMeses(int garantiaMeses) {
		this.garantiaMeses = garantiaMeses;
	}

	@Override
	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;
		Eletronico that = (Eletronico) o;
		return garantiaMeses == that.garantiaMeses;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), garantiaMeses);
	}

	@Override
	public String toString() {
		return "Eletronico{id=" + getId() + 
				", nome='" + getNome() + 
				"', preco=" + getPreco() + 
				", garantiaMeses=" + garantiaMeses + 
				"}";
	}
}