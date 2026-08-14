package exercicios14082026parte0.oo.exercicio1;

public class TransacaoBoleto extends TransacaoFinanceira {

	private String codigoBarras;

	public TransacaoBoleto() {
		super();
	}

	public TransacaoBoleto(double valor, String status, String codigoBarras) {
		super(valor, status);
		this.codigoBarras = codigoBarras;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	@Override
	public void processarPagamento(Aluguel aluguel) {
		setStatus("PENDENTE_BOLETO");
		setValor(aluguel.calcularValorFinal());
	}

	@Override
	public double calcularTaxa(Aluguel aluguel) {
		return 2.50;
	}

	@Override
	public void exportar() {
		System.out.println("Exportando relatorio da Transacao Boleto ID: " + getId());
	}

	@Override
	public String toString() {
		return "TransacaoBoleto [codigoBarras=" + codigoBarras + ", toString()=" + super.toString() + "]";
	}
}