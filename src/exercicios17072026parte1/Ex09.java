package exercicios17072026parte1;

public class Ex09 {

	private double valorProduto = 0;
	private double valorComDesconto = 0;

	public Ex09() { }

	public Ex09(double valorProduto) {		
		this.valorProduto = valorProduto;
		this.getValorComDesconto();
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public double getValorComDesconto() {
		this.valorComDesconto = this.valorProduto - (this.valorProduto * 0.09);
		return this.valorComDesconto;
	}

	@Override
	public String toString() {
		return "Ex09 [valorProduto=" + valorProduto + ", valorComDesconto=" + valorComDesconto + "]";
	}

}