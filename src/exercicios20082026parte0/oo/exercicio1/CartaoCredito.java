package exercicios20082026parte0.oo.exercicio1;

public class CartaoCredito implements Pagamento{

	private String numeroCartao;
	private String nomeTitular;
	
	public CartaoCredito() {
	}
	
	public CartaoCredito(String numeroCartao, String nomeTitular) {
		super();
		this.numeroCartao = numeroCartao;
		this.nomeTitular = nomeTitular;
	}

	@Override
	public void processarPagamento(double valor) {
	
	}
	@Override
	public String obterDetalhes() {
		return null;
	}
	
	
}
