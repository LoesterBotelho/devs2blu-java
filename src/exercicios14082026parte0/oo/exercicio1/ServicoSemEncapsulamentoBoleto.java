package exercicios14082026parte0.oo.exercicio1;

public class ServicoSemEncapsulamentoBoleto implements RelatorioService {

	public String codigoIdentificacao;
	public double taxaBoleto;

	public ServicoSemEncapsulamentoBoleto() {
	}

	public ServicoSemEncapsulamentoBoleto(String codigoIdentificacao, double taxaBoleto) {
		this.codigoIdentificacao = codigoIdentificacao;
		this.taxaBoleto = taxaBoleto;
	}

	public String getCodigoIdentificacao() {
		return codigoIdentificacao;
	}

	public void setCodigoIdentificacao(String codigoIdentificacao) {
		this.codigoIdentificacao = codigoIdentificacao;
	}

	public double getTaxaBoleto() {
		return taxaBoleto;
	}

	public void setTaxaBoleto(double taxaBoleto) {
		this.taxaBoleto = taxaBoleto;
	}

	@Override
	public void exportar() {
		System.out.println("Exportando relatorio sem encapsulamento para boleto: " + codigoIdentificacao);
	}

	@Override
	public String toString() {
		return "ServicoSemEncapsulamentoBoleto [codigoIdentificacao=" + codigoIdentificacao + ", taxaBoleto="
				+ taxaBoleto + "]";
	}
}