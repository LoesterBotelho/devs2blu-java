package exercicios25072026parte1.contabil.relatorio;

import java.math.BigDecimal;
import java.time.LocalDate;

import exercicios25072026parte1.contabil.enums.TipoMovimento;

public class LivroDiarioRelatorio {

	private LocalDate data;

	private String documento;

	private String historico;

	private String conta;

	private TipoMovimento movimento;

	private BigDecimal valor;

	public LivroDiarioRelatorio(LocalDate data, String documento, String historico, String conta,
			TipoMovimento movimento, BigDecimal valor) {

		this.data = data;
		this.documento = documento;
		this.historico = historico;
		this.conta = conta;
		this.movimento = movimento;
		this.valor = valor;

	}

	public LocalDate getData() {

		return data;

	}

	public String getDocumento() {

		return documento;

	}

	public String getHistorico() {

		return historico;

	}

	public String getConta() {

		return conta;

	}

	public TipoMovimento getMovimento() {

		return movimento;

	}

	public BigDecimal getValor() {

		return valor;

	}

	@Override
	public String toString() {

		return String.format(

				"%s | %-10s | %-20s | %-30s | %-8s | R$ %s",

				data, documento, historico, conta, movimento, valor

		);

	}

}