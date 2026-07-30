package poo.exercicios01;

public class Eletronico {

	private int numero = 0;
	private String nome = "";
	private String cor = "";

	public Eletronico() {
	}

	public Eletronico(int numero, String nome, String cor) {
		this.numero = numero;
		this.nome = nome;
		this.cor = cor;
	}

	public void ligar() {
		System.out.println("Ligado Acionado");
	}

	public void desligar() {
		System.out.println("Desligado Acionado");
	}

	public void exibir() {
		System.out.println(this.toString());
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "Eletronico [numero=" + numero + ", nome=" + nome + ", cor=" + cor + "]";
	}

}
