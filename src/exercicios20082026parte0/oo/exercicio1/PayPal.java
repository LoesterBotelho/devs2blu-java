package exercicios20082026parte0.oo.exercicio1;

public class PayPal implements Pagamento {

	private String email;

	public PayPal() {
	}

	public PayPal(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "PayPal [email=" + email + "]";
	}

	@Override
	public void processarPagamento(double valor) {
		
		String comprovante = String.format("Processando pagamento de R$ %.2f com PayPal.\n\n", valor) + 
		                   this.obterDetalhes();
		
		System.out.println( comprovante );		
	}

	@Override
	public String obterDetalhes() {
		
		return "Pagamento via PayPal\n" + 
		       "Email: " + this.getEmail() + "\n" ;
	}

}
