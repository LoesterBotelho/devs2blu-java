package exercicios14082026parte0.oo.exercicio1;

public class ServicoSemEncapsulamento implements RelatorioService {

	public String tipoRelatorio;
	public double custoOperacional;

	public ServicoSemEncapsulamento() {
	}

	public ServicoSemEncapsulamento(String tipoRelatorio, double custoOperacional) {
		this.tipoRelatorio = tipoRelatorio;
		this.custoOperacional = custoOperacional;
	}

	public String getTipoRelatorio() {
		return tipoRelatorio;
	}

	public void setTipoRelatorio(String tipoRelatorio) {
		this.tipoRelatorio = tipoRelatorio;
	}

	public double getCustoOperacional() {
		return custoOperacional;
	}

	public void setCustoOperacional(double custoOperacional) {
		this.custoOperacional = custoOperacional;
	}

	@Override
	public void exportar() {
		System.out.println("Exportando relatorio sem encapsulamento: " + tipoRelatorio);
	}

	@Override
	public String toString() {
		return "ServicoSemEncapsulamento [tipoRelatorio=" + tipoRelatorio + ", custoOperacional=" + custoOperacional
				+ "]";
	}
}