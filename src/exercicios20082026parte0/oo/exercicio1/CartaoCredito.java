package exercicios20082026parte0.oo.exercicio1;

public class CartaoCredito implements Pagamento {

	private String numeroCartao;
	private String nomeTitular;

	public CartaoCredito() {
	}

	public CartaoCredito(String numeroCartao, String nomeTitular) {
		this.numeroCartao = numeroCartao;
		this.nomeTitular = nomeTitular;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public String getUltimosQuatrosDigitos() {
		return numeroCartao.substring( numeroCartao.length() - 4 );
	}
	
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	@Override
	public String toString() {
		return "CartaoCredito [numeroCartao=" + numeroCartao + 
				", nomeTitular=" + nomeTitular + 
				"]";
	}
	
	@Override
	public void processarPagamento(double valor) {
		
		String comprovante = String.format("Processando pagamento de R$ %.2f com cartão de crédito.\n\n", valor) + 
		                   this.obterDetalhes();
		
		System.out.println( comprovante );		
	}

	@Override
	public String obterDetalhes() {
		
		return "Pagamento via Cartão de Crédito\n" + 
		       "Nome do Titular: " + this.getNomeTitular() + "\n" +
		       "Número do Cartão: **** **** **** " + this.getUltimosQuatrosDigitos() + "\n";
	}

}
