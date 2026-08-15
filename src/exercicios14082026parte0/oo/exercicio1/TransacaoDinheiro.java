package exercicios14082026parte0.oo.exercicio1;

public class TransacaoDinheiro extends TransacaoFinanceira {

	private double valorRecebido;

	public TransacaoDinheiro() {
		super();
	}

	public TransacaoDinheiro(double valor, String status, double valorRecebido) {
		super(valor, status);
		this.valorRecebido = valorRecebido;
	}

	public double getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(double valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	@Override
	public void processarPagamento(Aluguel aluguel) {
		setStatus("APROVADO_DINHEIRO");
		setValor(aluguel.calcularValorFinal());
	}

	@Override
	public double calcularTaxa(Aluguel aluguel) {
		return 0.0;
	}

	@Override
	public void exportar() {
		System.out.println("Exportando relatorio da Transacao Dinheiro ID: " + getId());
	}

	@Override
	public String toString() {
		return "TransacaoDinheiro [valorRecebido=" + valorRecebido + ", toString()=" + super.toString() + "]";
	}
}