package exercicios23082026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class ContaFinanceira {
	private BigDecimal valor;
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	private BigDecimal juros;
	private BigDecimal multa;
	private BigDecimal valorPago;
	private String observacao;

	public abstract BigDecimal calcularValorTotal();
	
	public ContaFinanceira() {

	}

	public ContaFinanceira(
			BigDecimal valor,
			LocalDate dataVencimento,
			LocalDate dataPagamento,
			BigDecimal juros,
			BigDecimal multa,
			BigDecimal valorPago,
			String observacao) {

		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.juros = juros;
		this.multa = multa;
		this.valorPago = valorPago;
		this.observacao = observacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getJuros() {
		return juros;
	}

	public void setJuros(BigDecimal juros) {
		this.juros = juros;
	}

	public BigDecimal getMulta() {
		return multa;
	}

	public void setMulta(BigDecimal multa) {
		this.multa = multa;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "ContaFinanceira [valor=" + valor
				+ ", dataVencimento=" + dataVencimento
				+ ", dataPagamento=" + dataPagamento
				+ ", juros=" + juros
				+ ", multa=" + multa
				+ ", valorPago=" + valorPago
				+ ", observacao=" + observacao
				+ "]";
	}

}