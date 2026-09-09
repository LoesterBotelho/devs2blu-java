package exercicios08092026parte0.oo.exercicio3;

import java.util.Objects;

class Cachorro extends Animal {
	private String raca;

	public Cachorro() {
		super();
	}

	public Cachorro(Long id, String nome, String raca) {
		super(id, nome);
		this.raca = raca;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	@Override
	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;
		Cachorro cachorro = (Cachorro) o;
		return Objects.equals(raca, cachorro.raca);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), raca);
	}

	@Override
	public String toString() {
		return "Cachorro{id=" + getId() + 
				", nome='" + getNome() + 
				"', raca='" + raca + 
				"'}";
	}
}