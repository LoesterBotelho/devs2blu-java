package exercicios08092026parte0.oo.exercicio1;

import java.util.Objects;

class Moto extends Veiculo {
	private int cilindradas;

	public Moto() {
		super();
	}

	public Moto(Long id, String modelo, int cilindradas) {
		super(id, modelo);
		this.cilindradas = cilindradas;
	}

	public int getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(int cilindradas) {
		this.cilindradas = cilindradas;
	}

	@Override
	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;
		Moto moto = (Moto) o;
		return cilindradas == moto.cilindradas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), cilindradas);
	}

	@Override
	public String toString() {
		return "Moto{id=" + getId() + 
				", modelo='" + getModelo() + 
				"', cilindradas=" + cilindradas + 
				"}";
	}
}