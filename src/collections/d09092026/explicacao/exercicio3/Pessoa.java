package collections.d09092026.explicacao.exercicio3;

public class Pessoa {
	private String cpf;

	public Pessoa(String cpf) {
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Pessoa))
			return false;

		Pessoa outra = (Pessoa) obj;
		return cpf.equals(outra.cpf);
	}

	@Override
	public int hashCode() {
		return cpf.hashCode();
	}
}