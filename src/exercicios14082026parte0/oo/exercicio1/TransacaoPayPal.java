package exercicios14082026parte0.oo.exercicio1;

public class TransacaoPayPal extends TransacaoFinanceira {

	private String emailConta;

	public TransacaoPayPal() {
		super();
	}

	public TransacaoPayPal(double valor, String status, String emailConta) {
		super(valor, status);
		this.emailConta = emailConta;
	}

	public String getEmailConta() {
		return emailConta;
	}

	public void setEmailConta(String emailConta) {
		this.emailConta = emailConta;
	}

	@Override
	public void processarPagamento(Aluguel aluguel) {
		setStatus("APROVADO_PAYPAL");
		setValor(aluguel.calcularValorFinal());
	}

	@Override
	public double calcularTaxa(Aluguel aluguel) {
		return aluguel.calcularValorFinal() * 0.045;
	}

	@Override
	public void exportar() {
		System.out.println("Exportando relatorio da Transacao PayPal ID: " + getId());
	}

	@Override
	public String toString() {
		return "TransacaoPayPal [emailConta=" + emailConta + ", toString()=" + super.toString() + "]";
	}
}