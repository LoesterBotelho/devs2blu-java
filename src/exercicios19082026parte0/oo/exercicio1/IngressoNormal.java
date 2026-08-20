package exercicios19082026parte0.oo.exercicio1;

public final class IngressoNormal extends Ingresso {

	public IngressoNormal() {
		super(1, 195.00, "Arquibancada", "Normal");

	}

	public IngressoNormal(int quantidadeIngressos) {
		super(quantidadeIngressos, 195.00, "Arquibancada", "Normal");		
	}

	@Override
	public void imprimeValor() {
		System.out.println("Ingresso " + this.getTipo() + " - Valor : " + this.getValor());

	}

	@Override
	public void imprimeTipo() {
		System.out.println("Ingresso " + this.getTipo() + " - Tipo : " + this.getTipo());
	}

	@Override
	public void valorTotal() {
		System.out.println("Ingresso " + this.getTipo() + " -" + 
	            " Quantidade : " + this.getQuantidadeIngressos() + 
				" , Valor Total : " + this.getValorTotal() +
				" , Descrição : " + this.getDescricacao()
		);
	}
	
}
