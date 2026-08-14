package exercicios13082026parte0.oo.heranca.exercicio01;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaPagar implements ContaFinanceira {

	private Long id;
	private String descricao;
	private BigDecimal valor;
	private LocalDate dataEmissao;
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	private boolean paga;
	private String observacao;

	public ContaPagar() {
	}

	public ContaPagar(Long id, String descricao, BigDecimal valor, LocalDate dataEmissao, LocalDate dataVencimento,
			String observacao) {

		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.dataEmissao = dataEmissao;
		this.dataVencimento = dataVencimento;
		this.observacao = observacao;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getDescricao() {
		return descricao;
	}

	@Override
	public BigDecimal getValor() {
		return valor;
	}

	@Override
	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	@Override
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	@Override
	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	@Override
	public boolean isPaga() {
		return paga;
	}

	@Override
	public String getObservacao() {
		return observacao;
	}

	@Override
	public void pagar(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
		this.paga = true;
	}

	@Override
	public void cancelar() {
		this.paga = false;
		this.dataPagamento = null;
	}
}