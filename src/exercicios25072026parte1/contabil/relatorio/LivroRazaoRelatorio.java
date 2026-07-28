package exercicios25072026parte1.contabil.relatorio;

import java.math.BigDecimal;
import java.time.LocalDate;

import exercicios25072026parte1.contabil.enums.TipoMovimento;

public class LivroRazaoRelatorio {

	private LocalDate data;

	private String conta;

	private String historico;

	private TipoMovimento movimento;

	private BigDecimal valor;

	private BigDecimal saldo;

	public LivroRazaoRelatorio(LocalDate data, String conta, String historico, TipoMovimento movimento,
			BigDecimal valor, BigDecimal saldo) {

		this.data = data;
		this.conta = conta;
		this.historico = historico;
		this.movimento = movimento;
		this.valor = valor;
		this.saldo = saldo;

	}

	public LocalDate getData() {

		return data;

	}

	public String getConta() {

		return conta;

	}

	public String getHistorico() {

		return historico;

	}

	public TipoMovimento getMovimento() {

		return movimento;

	}

	public BigDecimal getValor() {

		return valor;

	}

	public BigDecimal getSaldo() {

		return saldo;

	}

	@Override
	public String toString() {

		return String.format("%s | %-25s | %-8s | R$ %10s | Saldo: R$ %10s", data, historico, movimento, valor, saldo);

	}

}