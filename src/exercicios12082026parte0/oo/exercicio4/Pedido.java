package exercicios12082026parte0.oo.exercicio4;

import java.util.Objects;

public class Pedido {
	private static int contadorId = 1;
	private int id;
	private String cliente;
	private double valorTotal;

	public Pedido() {
		this.id = contadorId++;
	}

	public Pedido(String cliente, double valorTotal) {
		this();
		this.cliente = cliente;
		this.valorTotal = valorTotal;
	}

	public int getId() {
		return id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", valorTotal=" + valorTotal + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return id == other.id;
	}
}