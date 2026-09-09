package exercicios08092026parte0.oo.exercicio1;

import java.util.Objects;

class Veiculo {
	private Long id;
	private String modelo;

	public Veiculo() {
	}

	public Veiculo(Long id, String modelo) {
		this.id = id;
		this.modelo = modelo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Veiculo veiculo = (Veiculo) o;
		return Objects.equals(id, veiculo.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Veiculo{id=" + id + 
				", modelo='" + modelo + 
				"'}";
	}
}