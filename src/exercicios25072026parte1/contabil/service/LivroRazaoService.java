package exercicios25072026parte1.contabil.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

import exercicios25072026parte1.contabil.model.ItemLancamento;
import exercicios25072026parte1.contabil.model.LancamentoContabil;
import exercicios25072026parte1.contabil.model.PlanoConta;
import exercicios25072026parte1.contabil.relatorio.LivroRazaoRelatorio;

public class LivroRazaoService {

	private final LancamentoContabilService lancamentoService;

	public LivroRazaoService(LancamentoContabilService lancamentoService) {

		this.lancamentoService = lancamentoService;

	}

	public Map<PlanoConta, List<ItemLancamento>> agruparPorConta() {

		return lancamentoService.listar()
				.stream()
				.flatMap(
						lancamento ->
						lancamento.getItens().stream()
				)
				.collect(
						Collectors.groupingBy(
								ItemLancamento::getConta
						)
				);

	}

	public List<LivroRazaoRelatorio> gerar(PlanoConta conta) {

		List<ItemLancamento> itens =
				agruparPorConta()
						.getOrDefault(conta, List.of());

		List<LivroRazaoRelatorio> resultado = new ArrayList<>();

		BigDecimal saldo = BigDecimal.ZERO;

		for (ItemLancamento item : itens) {

			if (item.isDebito()) {
				saldo = saldo.add(item.getValor());
			} else {
				saldo = saldo.subtract(item.getValor());
			}

			resultado.add(

					new LivroRazaoRelatorio(

							encontrarData(item),

							conta.toString(),

							"Movimento contábil",

							item.getMovimento(),

							item.getValor(),

							saldo

					)

			);

		}

		return resultado;

	}

	private java.time.LocalDate encontrarData(ItemLancamento item) {

		return lancamentoService.listar()

				.stream()

				.filter(

						l ->

						l.getItens().contains(item)

				)

				.findFirst()

				.map(LancamentoContabil::getData)

				.orElse(null);

	}

}