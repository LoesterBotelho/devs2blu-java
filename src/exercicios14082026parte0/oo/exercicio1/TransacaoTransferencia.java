package exercicios14082026parte0.oo.exercicio1;

public class TransacaoTransferencia extends TransacaoFinanceira {

	private String bancoDestino;

	public TransacaoTransferencia() {
		super();
	}

	public TransacaoTransferencia(double valor, String status, String bancoDestino) {
		super(valor, status);
		this.bancoDestino = bancoDestino;
	}

	public String getBancoDestino() {
		return bancoDestino;
	}

	public void setBancoDestino(String bancoDestino) {
		this.bancoDestino = bancoDestino;
	}

	@Override
	public void processarPagamento(Aluguel aluguel) {
		setStatus("PENDENTE_TRANSFERENCIA");
		setValor(aluguel.calcularValorFinal());
	}

	@Override
	public double calcularTaxa(Aluguel aluguel) {
		return 5.00;
	}

	@Override
	public void exportar() {
		System.out.println("Exportando relatorio da Transacao Transferencia ID: " + getId());
	}

	@Override
	public String toString() {
		return "TransacaoTransferencia [bancoDestino=" + bancoDestino + ", toString()=" + super.toString() + "]";
	}
}