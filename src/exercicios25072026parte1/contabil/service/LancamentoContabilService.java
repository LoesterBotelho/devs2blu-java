package exercicios25072026parte1.contabil.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import exercicios25072026parte1.contabil.model.ItemLancamento;
import exercicios25072026parte1.contabil.model.LancamentoContabil;
import exercicios25072026parte1.contabil.model.PlanoConta;
import exercicios25072026parte1.contabil.repository.LancamentoRepository;

public class LancamentoContabilService {

	private final LancamentoRepository repository;

	public LancamentoContabilService(LancamentoRepository repository) {

		this.repository = repository;

	}

	/**
	 * Salva lançamento contábil
	 */
	public void salvar(LancamentoContabil lancamento) {

		validar(lancamento);

		atualizarSaldo(lancamento);

		repository.salvar(lancamento);

	}

	/**
	 * Buscar lançamento por ID
	 */
	public Optional<LancamentoContabil> buscar(Integer id) {

		return repository.buscar(id);

	}

	/**
	 * Lista lançamentos ordenados por data
	 */
	public List<LancamentoContabil> listar() {

		return repository.listarOrdenado(

				Comparator.comparing(LancamentoContabil::getData)

		);

	}

	/**
	 * Lista por período
	 */
	public List<LancamentoContabil> listarPeriodo(LocalDate inicio, LocalDate fim) {

		return repository.listar()

				.stream()

				.filter(

						lancamento ->

						!lancamento.getData().isBefore(inicio)

								&&

								!lancamento.getData().isAfter(fim)

				)

				.toList();

	}

	/**
	 * Total de débitos
	 */
	public BigDecimal totalDebitos() {

		return repository.listar()

				.stream()

				.map(LancamentoContabil::totalDebito)

				.reduce(BigDecimal.ZERO, BigDecimal::add);

	}

	/**
	 * Total de créditos
	 */
	public BigDecimal totalCreditos() {

		return repository.listar()

				.stream()

				.map(LancamentoContabil::totalCredito)

				.reduce(BigDecimal.ZERO, BigDecimal::add);

	}

	/**
	 * Remove lançamento e desfaz saldo
	 */
	public void remover(Integer id) {

		LancamentoContabil lancamento =

				repository.buscar(id)

						.orElseThrow(

								() ->

								new RuntimeException("Lançamento não encontrado")

						);

		reverterSaldo(lancamento);

		repository.removerPorId(id);

	}

	/**
	 * Validação geral
	 */
	private void validar(LancamentoContabil lancamento) {

		if (lancamento == null) {

			throw new RuntimeException("Lançamento obrigatório");

		}

		if (lancamento.getData() == null) {

			throw new RuntimeException("Data obrigatória");

		}

		if (lancamento.getItens() == null ||

				lancamento.getItens().isEmpty()) {

			throw new RuntimeException("Lançamento sem itens");

		}

		validarItens(lancamento);

		if (!lancamento.partidaDobradaValida()) {

			throw new RuntimeException(

					"Débito deve ser igual ao crédito"

			);

		}

	}

	/**
	 * Validação dos itens
	 */
	private void validarItens(LancamentoContabil lancamento) {

		boolean possuiDebito = false;

		boolean possuiCredito = false;

		for (ItemLancamento item : lancamento.getItens()) {

			if (item == null) {

				throw new RuntimeException("Item inválido");

			}

			PlanoConta conta = item.getConta();

			if (conta == null) {

				throw new RuntimeException("Conta obrigatória");

			}

			if (!conta.isAnalitica()) {

				throw new RuntimeException(

						"Somente contas analíticas recebem lançamento: " + conta

				);

			}

			if (item.getValor() == null ||

					item.getValor().compareTo(BigDecimal.ZERO) <= 0) {

				throw new RuntimeException("Valor inválido");

			}

			if (item.isDebito()) {

				possuiDebito = true;

			}

			if (item.isCredito()) {

				possuiCredito = true;

			}

		}

		if (!possuiDebito) {

			throw new RuntimeException("Não existe débito");

		}

		if (!possuiCredito) {

			throw new RuntimeException("Não existe crédito");

		}

	}

	/**
	 * Atualiza saldo das contas
	 */
	private void atualizarSaldo(LancamentoContabil lancamento) {

		lancamento.getItens()

				.forEach(

						item -> {

							PlanoConta conta = item.getConta();

							BigDecimal saldoAtual =

									conta.getSaldo() == null

											?

											BigDecimal.ZERO

											:

											conta.getSaldo();

							if (item.isDebito()) {

								conta.setSaldo(

										saldoAtual.add(item.getValor())

						);

							}

						else {

								conta.setSaldo(

										saldoAtual.subtract(item.getValor())

						);

							}

						}

				);

	}

	/**
	 * Reverte saldo ao remover lançamento
	 */
	private void reverterSaldo(LancamentoContabil lancamento) {

		lancamento.getItens()

				.forEach(

						item -> {

							PlanoConta conta = item.getConta();

							BigDecimal saldoAtual =

									conta.getSaldo() == null

											?

											BigDecimal.ZERO

											:

											conta.getSaldo();

							if (item.isDebito()) {

								conta.setSaldo(

										saldoAtual.subtract(item.getValor())

						);

							}

						else {

								conta.setSaldo(

										saldoAtual.add(item.getValor())

						);

							}

						}

				);

	}

}