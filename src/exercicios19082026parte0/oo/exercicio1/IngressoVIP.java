package exercicios19082026parte0.oo.exercicio1;

public final class IngressoVIP extends Ingresso {

	public IngressoVIP() {
		super(1, 600.00, "Pista Premium / Frontstage", "VIP");

	}

	public IngressoVIP(int quantidadeIngressos) {
		super(quantidadeIngressos, 600.00, "Pista Premium / Frontstage", "VIP");		
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
