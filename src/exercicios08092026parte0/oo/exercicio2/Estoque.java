package exercicios08092026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Estoque<T extends Produto> {
	private Long id;
	private List<T> itens;

	public Estoque() {
		this.itens = new ArrayList<>();
	}

	public Estoque(Long id, List<T> itens) {
		this.id = id;
		this.itens = itens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<T> getItens() {
		return itens;
	}

	public void setItens(List<T> itens) {
		this.itens = itens;
	}

	public void adicionarItem(T item) {
		this.itens.add(item);
	}

	public void listarItens() {
		for (T item : itens) {
			System.out.println(item);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Estoque<?> estoque = (Estoque<?>) o;
		return Objects.equals(id, estoque.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Estoque{id=" + id + 
				", totalItens=" + itens.size() + 
				"}";
	}
}