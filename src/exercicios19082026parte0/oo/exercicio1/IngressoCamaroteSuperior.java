package exercicios19082026parte0.oo.exercicio1;

public final class IngressoCamaroteSuperior extends Ingresso {

	
	public IngressoCamaroteSuperior() {
		super(1, 1200.00, "Camarote Superior", "Superior");

	}

	public IngressoCamaroteSuperior(int quantidadeIngressos) {
		super(quantidadeIngressos, 1200.00, "Camarote Superior", "Superior");		
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
