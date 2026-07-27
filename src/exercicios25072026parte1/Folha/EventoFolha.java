package exercicios25072026parte1.Folha;

public class EventoFolha {

	private String codigo;
	private String descricao;
	private double valor;
	private boolean provento;

	public EventoFolha(String codigo, String descricao, double valor, boolean provento) {

		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.provento = provento;

	}

	public String getCodigo() {

		return codigo;

	}

	public String getDescricao() {

		return descricao;

	}

	public double getValor() {

		return valor;

	}

	public boolean isProvento() {

		return provento;

	}

	public void imprimir() {
		String tipo = provento ? "PROVENTO" : "DESCONTO";
		System.out.printf("%-10s %-30s %-10s R$ %.2f%n", codigo, descricao, tipo, valor);

	}

}