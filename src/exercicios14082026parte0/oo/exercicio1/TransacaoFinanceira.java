package exercicios14082026parte0.oo.exercicio1;

public abstract class TransacaoFinanceira implements PagamentoService<Aluguel>, RelatorioService {

	private static int contadorId = 1;
	private int id;
	private double valor;
	private String status;

	public TransacaoFinanceira() {
		this.id = contadorId++;
	}

	public TransacaoFinanceira(double valor, String status) {
		this();
		this.valor = valor;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TransacaoFinanceira [id=" + id + ", valor=" + valor + ", status=" + status + "]";
	}
}