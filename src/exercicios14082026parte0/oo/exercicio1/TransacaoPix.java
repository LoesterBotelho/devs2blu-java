package exercicios14082026parte0.oo.exercicio1;

public class TransacaoPix extends TransacaoFinanceira {

	private String chavePix;

	public TransacaoPix() {
		super();
	}

	public TransacaoPix(double valor, String status, String chavePix) {
		super(valor, status);
		this.chavePix = chavePix;
	}

	public String getChavePix() {
		return chavePix;
	}

	public void setChavePix(String chavePix) {
		this.chavePix = chavePix;
	}

	@Override
	public void processarPagamento(Aluguel aluguel) {
		setStatus("APROVADO_PIX");
		setValor(aluguel.calcularValorFinal());
	}

	@Override
	public double calcularTaxa(Aluguel aluguel) {
		return 0.0;
	}

	@Override
	public void exportar() {
		System.out.println("Exportando relatorio da Transacao Pix ID: " + getId());
	}

	@Override
	public String toString() {
		return "TransacaoPix [chavePix=" + chavePix + ", toString()=" + super.toString() + "]";
	}
}