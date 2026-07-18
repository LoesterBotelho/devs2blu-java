package exercicios17072026parte1;

public class Ex06 {


	private static final double PRECO_HORA = 0.08;
	private int quantidadePaginas = 0;
	private double precoTotal = 0;
	
	public Ex06() { }

	public Ex06(int quantidadePaginas) {		
		this.quantidadePaginas = quantidadePaginas;
		this.getPreco();
	}

	public double getPreco() {
		// Lembrete: cada folha corresponde a duas páginas, frente e verso		
		this.precoTotal = ((quantidadePaginas / 2) * PRECO_HORA);
		return precoTotal;
	}
	
	public void setQuantidadePaginas(int quantidadePaginas) {
		this.quantidadePaginas = quantidadePaginas;
	}

	public int getQuantidadePaginas() {
		return quantidadePaginas;
	}

	@Override
	public String toString() {
		return "Ex06 [quantidadePaginas=" + this.getQuantidadePaginas() + 
				", precoTotal=" + this.getPreco() + "]";
	}
		
}
