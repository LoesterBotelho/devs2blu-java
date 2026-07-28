package exercicios25072026parte1.contabil.relatorio;

import java.math.BigDecimal;

public class BalanceteRelatorio {

	private String codigo;

	private String conta;

	private BigDecimal saldoDevedor;

	private BigDecimal saldoCredor;

	public BalanceteRelatorio(String codigo, String conta, BigDecimal saldoDevedor, BigDecimal saldoCredor) {

		this.codigo = codigo;
		this.conta = conta;
		this.saldoDevedor = saldoDevedor;
		this.saldoCredor = saldoCredor;

	}

	public String getCodigo() {

		return codigo;

	}

	public String getConta() {

		return conta;

	}

	public BigDecimal getSaldoDevedor() {

		return saldoDevedor;

	}

	public BigDecimal getSaldoCredor() {

		return saldoCredor;

	}

	@Override
	public String toString() {

		return String.format("%-10s %-30s Débito: R$ %10s Crédito: R$ %10s", codigo, conta, saldoDevedor, saldoCredor);

	}

}