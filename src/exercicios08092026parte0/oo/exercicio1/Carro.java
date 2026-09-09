package exercicios08092026parte0.oo.exercicio1;

import java.util.Objects;

class Carro extends Veiculo {
	private int quantidadePortas;

	public Carro() {
		super();
	}

	public Carro(Long id, String modelo, int quantidadePortas) {
		super(id, modelo);
		this.quantidadePortas = quantidadePortas;
	}

	public int getQuantidadePortas() {
		return quantidadePortas;
	}

	public void setQuantidadePortas(int quantidadePortas) {
		this.quantidadePortas = quantidadePortas;
	}

	@Override
	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;
		Carro carro = (Carro) o;
		return quantidadePortas == carro.quantidadePortas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), quantidadePortas);
	}

	@Override
	public String toString() {
		return "Carro{id=" + getId() + 
				", modelo='" + getModelo() + 
				"', quantidadePortas=" + quantidadePortas + 
				"}";
	}
}