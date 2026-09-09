package exercicios08092026parte0.oo.exercicio3;

import java.util.Objects;

class Gato extends Animal {
	private String corPelagem;

	public Gato() {
		super();
	}

	public Gato(Long id, String nome, String corPelagem) {
		super(id, nome);
		this.corPelagem = corPelagem;
	}

	public String getCorPelagem() {
		return corPelagem;
	}

	public void setCorPelagem(String corPelagem) {
		this.corPelagem = corPelagem;
	}

	@Override
	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;
		Gato gato = (Gato) o;
		return Objects.equals(corPelagem, gato.corPelagem);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), corPelagem);
	}

	@Override
	public String toString() {
		return "Gato{id=" + getId() + 
				", nome='" + getNome() + 
				"', corPelagem='" + corPelagem + 
				"'}";
	}
}
