package exercicios14082026parte0.oo.exercicio1;

public class TransacaoCartao extends TransacaoFinanceira {

	private String numeroCartao;

	public TransacaoCartao() {
		super();
	}

	public TransacaoCartao(double valor, String status, String numeroCartao) {
		super(valor, status);
		this.numeroCartao = numeroCartao;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	@Override
	public void processarPagamento(Aluguel aluguel) {
		setStatus("APROVADO_CARTAO");
		setValor(aluguel.calcularValorFinal());
	}

	@Override
	public double calcularTaxa(Aluguel aluguel) {
		return aluguel.calcularValorFinal() * 0.03;
	}

	@Override
	public void exportar() {
		System.out.println("Exportando relatorio da Transacao Cartao ID: " + getId());
	}

	@Override
	public String toString() {
		return "TransacaoCartao [numeroCartao=" + numeroCartao + ", toString()=" + super.toString() + "]";
	}
}