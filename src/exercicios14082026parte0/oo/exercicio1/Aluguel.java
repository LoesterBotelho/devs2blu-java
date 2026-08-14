package exercicios14082026parte0.oo.exercicio1;

public class Aluguel {

	private static int contadorId = 1;

	private int id;
	private String nomeTema;
	private String dataFesta;
	private double valorCobrado;
	private Cliente cliente;

	public Aluguel() {
		this.id = contadorId++;
	}

	public Aluguel(String nomeTema, String dataFesta, double valorCobrado) {
		this();
		this.nomeTema = nomeTema;
		this.dataFesta = dataFesta;
		this.valorCobrado = valorCobrado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeTema() {
		return nomeTema;
	}

	public void setNomeTema(String nomeTema) {
		this.nomeTema = nomeTema;
	}

	public String getDataFesta() {
		return dataFesta;
	}

	public void setDataFesta(String dataFesta) {
		this.dataFesta = dataFesta;
	}

	public double getValorCobrado() {
		return valorCobrado;
	}

	public void setValorCobrado(double valorCobrado) {
		this.valorCobrado = valorCobrado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double calcularValorFinal() {
		if (this.cliente != null) {
			return this.cliente.aplicarDesconto(this.valorCobrado);
		}
		return this.valorCobrado;
	}

	@Override
	public String toString() {
		return "Aluguel [id=" + id + ", nomeTema=" + nomeTema + ", dataFesta=" + dataFesta + ", valorCobrado="
				+ valorCobrado + "]";
	}
}