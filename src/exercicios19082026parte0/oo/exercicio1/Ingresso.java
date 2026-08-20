package exercicios19082026parte0.oo.exercicio1;

public abstract class Ingresso {

	private double valor;
	private String local;
	private String tipo;
	private int quantidadeIngressos;

	public Ingresso() {
	}


	public Ingresso(int quantidadeIngressos, double valor, String local, String tipo) {		
		this.valor = valor;
		this.local = local;
		this.tipo = tipo;		
		this.quantidadeIngressos = quantidadeIngressos;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getQuantidadeIngressos() {
		return quantidadeIngressos;
	}

	public void setQuantidadeIngressos(int quantidadeIngressos) {
		this.quantidadeIngressos = quantidadeIngressos;
	}

	public double getValorTotal() {
		return this.getQuantidadeIngressos() * this.getValor();
	}
	
	public String getDescricacao() {
		return "Ingresso " + this.getTipo() + " - " + this.getLocal() ;
	}

	@Override
	public String toString() {
		return "Ingresso [valor=" + this.getValor() + 
				", local=" + this.getLocal() + 
				", tipo=" + this.getTipo() + 
				", descricacao=" + this.getDescricacao() + 				
				", quantidadeIngressos=" + this.getQuantidadeIngressos() + 
				", valorTotal=" + this.getValorTotal() + 
				"]";
	}

	public abstract void imprimeValor();
    public abstract void imprimeTipo();
    public abstract void valorTotal();

}
