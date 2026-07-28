package exercicios25072026parte1.contabil.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import exercicios25072026parte1.contabil.enums.StatusLancamento;

public class LancamentoContabil extends Entidade<Integer> {

	private static final long serialVersionUID = 1L;

	private LocalDate data;

	private String documento;

	private String historico;

	private StatusLancamento status;

	private LocalDate dataCancelamento;

	private String motivoCancelamento;

	private final List<ItemLancamento> itens = new ArrayList<>();

	public LancamentoContabil() {

		this.status = StatusLancamento.RASCUNHO;

	}

	public LancamentoContabil(Integer id, LocalDate data, String documento, String historico) {

		setId(id);

		this.data = data;

		this.documento = documento;

		this.historico = historico;

		this.status = StatusLancamento.RASCUNHO;

	}

	public LocalDate getData() {

		return data;

	}

	public void setData(LocalDate data) {

		validarAlteracao();

		this.data = data;

	}

	public String getDocumento() {

		return documento;

	}

	public void setDocumento(String documento) {

		validarAlteracao();

		this.documento = documento;

	}

	public String getHistorico() {

		return historico;

	}

	public void setHistorico(String historico) {

		validarAlteracao();

		this.historico = historico;

	}

	public StatusLancamento getStatus() {

		return status;

	}

	public void setStatus(StatusLancamento status) {

		this.status = Objects.requireNonNull(status, "Status obrigatório");

	}

	public LocalDate getDataCancelamento() {

		return dataCancelamento;

	}

	public String getMotivoCancelamento() {

		return motivoCancelamento;

	}

	public List<ItemLancamento> getItens() {

		return List.copyOf(itens);

	}

	/**
	 * Adiciona item e cria relacionamento com o lançamento
	 */
	public void adicionarItem(ItemLancamento item) {

		validarAlteracao();

		Objects.requireNonNull(item, "Item obrigatório");

		item.setLancamento(this);

		itens.add(item);

	}

	/**
	 * Remove item e remove vínculo
	 */
	public void removerItem(ItemLancamento item) {

		validarAlteracao();

		if (itens.remove(item)) {

			item.setLancamento(null);

		}

	}

	public int quantidadeItens() {

		return itens.size();

	}

	public boolean possuiItens() {

		return !itens.isEmpty();

	}

	public BigDecimal totalDebito() {

		return itens.stream()

				.filter(ItemLancamento::isDebito)

				.map(ItemLancamento::getValor)

				.filter(Objects::nonNull)

				.reduce(BigDecimal.ZERO, BigDecimal::add);

	}

	public BigDecimal totalCredito() {

		return itens.stream()

				.filter(ItemLancamento::isCredito)

				.map(ItemLancamento::getValor)

				.filter(Objects::nonNull)

				.reduce(BigDecimal.ZERO, BigDecimal::add);

	}

	public BigDecimal valorTotal() {

		return totalDebito().add(totalCredito());

	}

	/**
	 * Regra principal da contabilidade: Débito = Crédito
	 */
	public boolean partidaDobradaValida() {

		return totalDebito()

				.compareTo(totalCredito())

				== 0;

	}

	public void validar() {

		if (data == null) {

			throw new IllegalStateException("Data obrigatória");

		}

		if (historico == null || historico.isBlank()) {

			throw new IllegalStateException("Histórico obrigatório");

		}

		if (itens.isEmpty()) {

			throw new IllegalStateException("Lançamento sem itens");

		}

		for (ItemLancamento item : itens) {

			try {

				item.validar();

			} catch (Exception e) {

				throw new IllegalStateException(

						"Item inválido: " + item,

						e

				);

			}

		}

		if (!partidaDobradaValida()) {

			throw new IllegalStateException(

					"Débito deve ser igual ao crédito"

			);

		}

	}

	public void validarParaPostagem() {

		validar();

		if (status != StatusLancamento.RASCUNHO

				&&

				status != StatusLancamento.VALIDADO) {

			throw new IllegalStateException(

					"Lançamento não pode ser postado"

			);

		}

	}

	public void validarLancamento() {

		validar();

		this.status = StatusLancamento.VALIDADO;

	}

	public void postar() {

		validarParaPostagem();

		this.status = StatusLancamento.POSTADO;

	}

	public void cancelar(String motivo) {

		if (!estaPostado()) {

			throw new IllegalStateException(

					"Somente lançamento postado pode ser cancelado"

			);

		}

		if (motivo == null || motivo.isBlank()) {

			throw new IllegalArgumentException(

					"Informe o motivo do cancelamento"

			);

		}

		this.status = StatusLancamento.CANCELADO;

		this.dataCancelamento = LocalDate.now();

		this.motivoCancelamento = motivo;

	}

	public void validarAlteracao() {

		if (status == StatusLancamento.POSTADO) {

			throw new IllegalStateException(

					"Lançamento postado não pode ser alterado"

			);

		}

		if (status == StatusLancamento.CANCELADO) {

			throw new IllegalStateException(

					"Lançamento cancelado não pode ser alterado"

			);

		}

	}

	public boolean estaPostado() {

		return status == StatusLancamento.POSTADO;

	}

	public boolean estaValidado() {

		return status == StatusLancamento.VALIDADO;

	}

	public boolean estaCancelado() {

		return status == StatusLancamento.CANCELADO;

	}

	@Override
	public String toString() {

		return """

				==============================
				 LANÇAMENTO CONTÁBIL
				==============================
				ID..........: %s
				Data........: %s
				Documento...: %s
				Histórico...: %s
				Status......: %s
				Débito......: R$ %s
				Crédito.....: R$ %s
				Quantidade..: %s
				==============================

				""".formatted(

				getId(),

				data,

				documento,

				historico,

				status,

				totalDebito(),

				totalCredito(),

				itens.size()

		);

	}

}