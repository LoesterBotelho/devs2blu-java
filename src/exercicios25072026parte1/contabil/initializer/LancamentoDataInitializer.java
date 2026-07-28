package exercicios25072026parte1.contabil.initializer;

import java.math.BigDecimal;
import java.time.LocalDate;

import exercicios25072026parte1.contabil.enums.TipoMovimento;
import exercicios25072026parte1.contabil.model.CentroCusto;
import exercicios25072026parte1.contabil.model.ItemLancamento;
import exercicios25072026parte1.contabil.model.LancamentoContabil;
import exercicios25072026parte1.contabil.model.PlanoConta;
import exercicios25072026parte1.contabil.service.CentroCustoService;
import exercicios25072026parte1.contabil.service.LancamentoContabilService;
import exercicios25072026parte1.contabil.service.PlanoContaService;

public class LancamentoDataInitializer {

	private final LancamentoContabilService lancamentoService;

	private final PlanoContaService planoContaService;

	private final CentroCustoService centroCustoService;

	public LancamentoDataInitializer(LancamentoContabilService lancamentoService, PlanoContaService planoContaService,
			CentroCustoService centroCustoService) {

		this.lancamentoService = lancamentoService;

		this.planoContaService = planoContaService;

		this.centroCustoService = centroCustoService;

	}

	public void carregar() {

		if (!lancamentoService.listar().isEmpty()) {

			return;

		}

		PlanoConta caixa = buscarConta("1.1.01");

		PlanoConta capital = buscarConta("3.1.01");

		PlanoConta receita = buscarConta("4.1.01");

		PlanoConta salario = buscarConta("5.1.01");

		CentroCusto administrativo =

				centroCustoService.buscarPorCodigo("10")

						.orElseThrow(() -> new RuntimeException("Centro de custo Administrativo não encontrado"));

		CentroCusto rh =

				centroCustoService.buscarPorCodigo("10.01")

						.orElseThrow(() -> new RuntimeException("Centro de custo RH não encontrado"));

		/*
		 * ================================= 1 - Integralização de Capital
		 * =================================
		 */

		LancamentoContabil capitalSocial =

				new LancamentoContabil(

						null,

						LocalDate.now(),

						"DOC-001",

						"Integralização de capital"

				);

		capitalSocial.adicionarItem(

				new ItemLancamento(

						null,

						caixa,

						administrativo,

						TipoMovimento.DEBITO,

						new BigDecimal("10000.00")

				)

		);

		capitalSocial.adicionarItem(

				new ItemLancamento(

						null,

						capital,

						administrativo,

						TipoMovimento.CREDITO,

						new BigDecimal("10000.00")

				)

		);

		salvarPostar(capitalSocial);

		/*
		 * ================================= 2 - Pagamento de salários
		 * =================================
		 */

		LancamentoContabil pagamentoSalario =

				new LancamentoContabil(

						null,

						LocalDate.now(),

						"DOC-002",

						"Pagamento de salários"

				);

		pagamentoSalario.adicionarItem(

				new ItemLancamento(

						null,

						salario,

						rh,

						TipoMovimento.DEBITO,

						new BigDecimal("3000.00")

				)

		);

		pagamentoSalario.adicionarItem(

				new ItemLancamento(

						null,

						caixa,

						rh,

						TipoMovimento.CREDITO,

						new BigDecimal("3000.00")

				)

		);

		salvarPostar(pagamentoSalario);

		/*
		 * ================================= 3 - Venda de produtos
		 * =================================
		 */

		LancamentoContabil venda =

				new LancamentoContabil(

						null,

						LocalDate.now(),

						"DOC-003",

						"Venda de produtos"

				);

		venda.adicionarItem(

				new ItemLancamento(

						null,

						caixa,

						administrativo,

						TipoMovimento.DEBITO,

						new BigDecimal("5000.00")

				)

		);

		venda.adicionarItem(

				new ItemLancamento(

						null,

						receita,

						administrativo,

						TipoMovimento.CREDITO,

						new BigDecimal("5000.00")

				)

		);

		salvarPostar(venda);

	}

	private PlanoConta buscarConta(String codigo) {

		return planoContaService

				.buscarPorCodigo(codigo)

				.orElseThrow(

						() -> new RuntimeException(

								"Conta não encontrada: " + codigo

						)

				);

	}

	private void salvarPostar(LancamentoContabil lancamento) {

		lancamentoService.salvar(lancamento);

		lancamentoService.validar(lancamento.getId());

		lancamentoService.postar(lancamento.getId());

	}

}