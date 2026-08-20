package exercicios19082026parte0.oo.exercicio1;

public final class IngressoCamaroteInferior extends Ingresso {

	public IngressoCamaroteInferior() {
		super(1, 345.00, "Camarote Inferior", "Inferior");

	}

	public IngressoCamaroteInferior(int quantidadeIngressos) {
		super(quantidadeIngressos, 345.00, "Camarote Inferior", "Inferior");		
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
