package exercicios25072026parte1.contabil.service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

import exercicios25072026parte1.contabil.model.PlanoConta;
import exercicios25072026parte1.contabil.relatorio.BalanceteRelatorio;

public class BalanceteService {

	private final PlanoContaService planoContaService;

	public BalanceteService(PlanoContaService planoContaService) {

		this.planoContaService = planoContaService;

	}

	public List<BalanceteRelatorio> gerar() {

		return planoContaService.listar()
				.stream()
				.filter(PlanoConta::isAnalitica)
				.sorted(
						Comparator.comparing(PlanoConta::getCodigo)
				)
				.map(
						this::converter
				)
				.toList();

	}

	private BalanceteRelatorio converter(PlanoConta conta) {

		BigDecimal saldo = conta.getSaldo();
		BigDecimal debito = BigDecimal.ZERO;
		BigDecimal credito = BigDecimal.ZERO;

		if (saldo.compareTo(BigDecimal.ZERO) >= 0) {
			debito = saldo;
		} else {
			credito = saldo.abs();
		}

		return new BalanceteRelatorio(
				conta.getCodigo(),
				conta.getDescricao(),
				debito,
				credito
		);

	}

	public BigDecimal totalDebito() {

		return gerar()
				.stream()
				.map(BalanceteRelatorio::getSaldoDevedor)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public BigDecimal totalCredito() {

		return gerar()
				.stream()
				.map(BalanceteRelatorio::getSaldoCredor)
				.reduce(BigDecimal.ZERO, BigDecimal::add);

	}

	public boolean estaBalanceado() {

		return totalDebito()
				.compareTo(totalCredito())
				== 0;

	}

}