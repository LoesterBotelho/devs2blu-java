package exercicios17072026parte2;

public class Ex03 {

    private final double TAXA_CORRETAGEM = 0.02; // (2/100) = 0.02
   
    private int quantidadeAcoes = 0;
    private double precoCompra = 0.0;
    private double precoVenda = 0.0;
    
	public Ex03() { }

	public Ex03(int quantidadeAcoes, double precoCompra, double precoVenda) {
		this.quantidadeAcoes = quantidadeAcoes;
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
	}

	public int getQuantidadeAcoes() {
		return quantidadeAcoes;
	}
	
	public void setQuantidadeAcoes(int quantidadeAcoes) {
		this.quantidadeAcoes = quantidadeAcoes;
	}
	
	public double getPrecoCompra() {
		return precoCompra;
	}
	
	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}
	
	public double getPrecoVenda() {
		return precoVenda;
	}
	
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public double getValorCorretagemCompra() {		 
		return this.getValorCompra() * this.TAXA_CORRETAGEM; 
	}

	public double getValorCorretagemVenda() {
		return this.getValorVenda() * this.TAXA_CORRETAGEM;
	}
	
	public double getLucroPrejuizo() {
		return this.getValorVenda()-this.getValorCorretagemVenda()-
	           this.getValorCompra()-this.getValorCorretagemCompra();
	}

	public double getValorCompra() {
		return this.quantidadeAcoes * this.precoCompra;
	}

	public double getValorVenda() {
		return this.quantidadeAcoes * this.precoVenda;
	}

	@Override
	public String toString() {
		return "Ex03 [quantidadeAcoes=" + this.getQuantidadeAcoes() +
		          ", precoCompra=" + this.getValorCompra() + 
		          ", precoVenda=" + this.getPrecoVenda() + 
				  ", valorCompra=" + this.getValorCompra() + 
				  ", valorVenda=" + this.getValorVenda() +
				  ", valorCorretagemCompra=" + this.getValorCorretagemCompra() + 
				  ", getValorCorretagemVenda=" + this.getValorCorretagemVenda() + 
				  ", lucroPrejuizo=" + this.getLucroPrejuizo() + 
				  "]";
	}

}
