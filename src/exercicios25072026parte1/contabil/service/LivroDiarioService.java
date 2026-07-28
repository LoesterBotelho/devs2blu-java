package exercicios25072026parte1.contabil.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import exercicios25072026parte1.contabil.model.ItemLancamento;
import exercicios25072026parte1.contabil.model.LancamentoContabil;
import exercicios25072026parte1.contabil.relatorio.LivroDiarioRelatorio;

public class LivroDiarioService {

	private final LancamentoContabilService service;

	public LivroDiarioService(LancamentoContabilService service) {

		this.service = service;

	}

	public List<LivroDiarioRelatorio> gerar() {

		return service.listar()

				.stream()

				.flatMap(

						lancamento ->

						lancamento.getItens()

								.stream()

								.map(

										item -> converter(lancamento, item)

								)

				)

				.sorted(

						Comparator.comparing(LivroDiarioRelatorio::getData)

				)

				.collect(Collectors.toList());

	}

	public List<LivroDiarioRelatorio> gerarPeriodo(LocalDate inicio, LocalDate fim) {

		return gerar()

				.stream()

				.filter(

						linha ->

						!linha.getData().isBefore(inicio)

								&& !linha.getData().isAfter(fim)

				)

				.toList();

	}

	private LivroDiarioRelatorio converter(LancamentoContabil lancamento, ItemLancamento item) {

		return new LivroDiarioRelatorio(

				lancamento.getData(),

				lancamento.getDocumento(),

				lancamento.getHistorico(),

				item.getConta().toString(),

				item.getMovimento(),

				item.getValor()

		);

	}

}