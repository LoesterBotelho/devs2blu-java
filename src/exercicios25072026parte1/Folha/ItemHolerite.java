package exercicios25072026parte1.Folha;

public class ItemHolerite {

	private String descricao;

	private double valor;

	public ItemHolerite(String descricao, double valor) {

		this.descricao = descricao;
		this.valor = valor;

	}

	public String getDescricao() {

		return descricao;

	}

	public double getValor() {

		return valor;

	}

	public void imprimir() {

		System.out.printf("%-35s R$ %.2f%n", descricao, valor);

	}

}