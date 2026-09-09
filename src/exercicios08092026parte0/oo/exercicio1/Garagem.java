package exercicios08092026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Garagem<T extends Veiculo> {
	private Long id;
	private List<T> veiculos;

	public Garagem() {
		this.veiculos = new ArrayList<>();
	}

	public Garagem(Long id, List<T> veiculos) {
		this.id = id;
		this.veiculos = veiculos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<T> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<T> veiculos) {
		this.veiculos = veiculos;
	}

	public void adicionarVeiculo(T veiculo) {
		this.veiculos.add(veiculo);
	}

	public void listarVeiculos() {
		for (T veiculo : veiculos) {
			System.out.println(veiculo);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Garagem<?> garagem = (Garagem<?>) o;
		return Objects.equals(id, garagem.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Garagem{id=" + id + 
				", totalVeiculos=" + veiculos.size() + 
				"}";
	}
}