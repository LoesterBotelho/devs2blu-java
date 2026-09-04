package exercicios03092026parte0.oo.exercicio2;

public class Codigo {
	private String setor;
	private int numero;

	public Codigo(String setor, int numero) {
		this.setor = setor;
		this.numero = numero;
	}

	public String getSetor() {
		return setor;
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return setor + numero;
	}
}