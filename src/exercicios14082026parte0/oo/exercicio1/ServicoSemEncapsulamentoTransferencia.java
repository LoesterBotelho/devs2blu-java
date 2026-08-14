package exercicios14082026parte0.oo.exercicio1;

public class ServicoSemEncapsulamentoTransferencia implements RelatorioService {

	public String codigoCompensacao;
	public double tarifaTed;

	public ServicoSemEncapsulamentoTransferencia() {
	}

	public ServicoSemEncapsulamentoTransferencia(String codigoCompensacao, double tarifaTed) {
		this.codigoCompensacao = codigoCompensacao;
		this.tarifaTed = tarifaTed;
	}

	public String getCodigoCompensacao() {
		return codigoCompensacao;
	}

	public void setCodigoCompensacao(String codigoCompensacao) {
		this.codigoCompensacao = codigoCompensacao;
	}

	public double getTarifaTed() {
		return tarifaTed;
	}

	public void setTarifaTed(double tarifaTed) {
		this.tarifaTed = tarifaTed;
	}

	@Override
	public void exportar() {
		System.out.println("Exportando relatorio sem encapsulamento para transferencia: " + codigoCompensacao);
	}

	@Override
	public String toString() {
		return "ServicoSemEncapsulamentoTransferencia [codigoCompensacao=" + codigoCompensacao + ", tarifaTed="
				+ tarifaTed + "]";
	}
}