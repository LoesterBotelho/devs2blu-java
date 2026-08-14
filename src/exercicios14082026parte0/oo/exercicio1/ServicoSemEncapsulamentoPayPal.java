package exercicios14082026parte0.oo.exercicio1;

public class ServicoSemEncapsulamentoPayPal implements RelatorioService {

	public String transacaoIdPayPal;
	public double taxaCambio;

	public ServicoSemEncapsulamentoPayPal() {
	}

	public ServicoSemEncapsulamentoPayPal(String transacaoIdPayPal, double taxaCambio) {
		this.transacaoIdPayPal = transacaoIdPayPal;
		this.taxaCambio = taxaCambio;
	}

	public String getTransacaoIdPayPal() {
		return transacaoIdPayPal;
	}

	public void setTransacaoIdPayPal(String transacaoIdPayPal) {
		this.transacaoIdPayPal = transacaoIdPayPal;
	}

	public double getTaxaCambio() {
		return taxaCambio;
	}

	public void setTaxaCambio(double taxaCambio) {
		this.taxaCambio = taxaCambio;
	}

	@Override
	public void exportar() {
		System.out.println("Exportando relatorio sem encapsulamento para PayPal: " + transacaoIdPayPal);
	}

	@Override
	public String toString() {
		return "ServicoSemEncapsulamentoPayPal [transacaoIdPayPal=" + transacaoIdPayPal + ", taxaCambio=" + taxaCambio
				+ "]";
	}
}