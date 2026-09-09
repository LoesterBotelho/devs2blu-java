package exercicios08092026parte0.oo.exercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Abrigo<T extends Animal> {
	private Long id;
	private List<T> animais;

	public Abrigo() {
		this.animais = new ArrayList<>();
	}

	public Abrigo(Long id, List<T> animais) {
		this.id = id;
		this.animais = animais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<T> getAnimais() {
		return animais;
	}

	public void setAnimais(List<T> animais) {
		this.animais = animais;
	}

	public void adicionarAnimal(T animal) {
		this.animais.add(animal);
	}

	public void listarAnimais() {
		for (T animal : animais) {
			System.out.println(animal);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Abrigo<?> abrigo = (Abrigo<?>) o;
		return Objects.equals(id, abrigo.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Abrigo{id=" + id + 
				", totalAnimais=" + animais.size() + 
				"}";
	}
}