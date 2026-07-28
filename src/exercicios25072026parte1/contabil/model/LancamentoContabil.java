package exercicios25072026parte1.contabil.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import exercicios25072026parte1.contabil.enums.StatusLancamento;

public class LancamentoContabil extends Entidade<Integer> {

	private static final long serialVersionUID = 1L;

	/*
	 * ====================================== DADOS DO LANÇAMENTO
	 * ======================================
	 */

	private LocalDate data;

	private String documento;

	private String historico;

	/*
	 * ====================================== STATUS
	 * ======================================
	 */

	private StatusLancamento status;

	private LocalDate dataCancelamento;

	private String motivoCancelamento;

	/*
	 * ====================================== ITENS
	 * ======================================
	 */

	private final List<ItemLancamento> itens = new ArrayList<>();

	/*
	 * ====================================== CONSTRUTORES
	 * ======================================
	 */

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

	/*
	 * ====================================== GETTERS / SETTERS
	 * ======================================
	 */

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

	/*
	 * ====================================== MÉTODOS AUXILIARES
	 * ======================================
	 */

	public boolean possuiDocumento() {

		return documento != null && !documento.isBlank();

	}

	public boolean possuiHistorico() {

		return historico != null && !historico.isBlank();

	}

	public boolean possuiItens() {

		return !itens.isEmpty();

	}

	public int quantidadeItens() {

		return itens.size();

	}

	public boolean estaRascunho() {

		return status == StatusLancamento.RASCUNHO;

	}

	public boolean estaValidado() {

		return status == StatusLancamento.VALIDADO;

	}

	public boolean estaPostado() {

		return status == StatusLancamento.POSTADO;

	}

	public boolean estaCancelado() {

		return status == StatusLancamento.CANCELADO;

	}

	/*
	 * ====================================== GERENCIAMENTO DOS ITENS
	 * ======================================
	 */

	public void adicionarItem(ItemLancamento item) {

		validarAlteracao();

		Objects.requireNonNull(item, "Item obrigatório");

		if (itens.contains(item)) {

			throw new IllegalStateException("Item já pertence ao lançamento");

		}

		if (item.getLancamento() != null && item.getLancamento() != this) {

			throw new IllegalStateException("Item já pertence a outro lançamento");

		}

		item.setLancamento(this);

		itens.add(item);

	}

	public void removerItem(ItemLancamento item) {

		validarAlteracao();

		Objects.requireNonNull(item, "Item obrigatório");

		if (!itens.remove(item)) {

			throw new IllegalStateException("Item não encontrado no lançamento");

		}

		item.setLancamento(null);

	}

	public void limparItens() {

		validarAlteracao();

		for (ItemLancamento item : itens) {

			item.setLancamento(null);

		}

		itens.clear();

	}

	public ItemLancamento getItem(int indice) {

		return itens.get(indice);

	}

	public java.util.Optional<ItemLancamento> buscarItem(Integer id) {

		return itens.stream()

				.filter(item -> Objects.equals(item.getId(), id))

				.findFirst();

	}

	/*
	 * ====================================== CONSULTAS
	 * ======================================
	 */

	public List<ItemLancamento> getDebitos() {

		return itens.stream()

				.filter(ItemLancamento::isDebito)

				.toList();

	}

	public List<ItemLancamento> getCreditos() {

		return itens.stream()

				.filter(ItemLancamento::isCredito)

				.toList();

	}

	public long quantidadeDebitos() {

		return getDebitos().size();

	}

	public long quantidadeCreditos() {

		return getCreditos().size();

	}

	public boolean possuiCentroCusto() {

		return itens.stream()

				.anyMatch(ItemLancamento::possuiCentroCusto);

	}

	/*
	 * ====================================== TOTAIS
	 * ======================================
	 */

	public BigDecimal totalDebito() {

		return getDebitos().stream()

				.map(ItemLancamento::valorAbsoluto)

				.reduce(BigDecimal.ZERO, BigDecimal::add);

	}

	public BigDecimal totalCredito() {

		return getCreditos().stream()

				.map(ItemLancamento::valorAbsoluto)

				.reduce(BigDecimal.ZERO, BigDecimal::add);

	}

	/**
	 * Valor financeiro do lançamento.
	 *
	 * Como na partida dobrada Débito = Crédito, basta retornar um dos lados.
	 */
	public BigDecimal valorLancamento() {

		return totalDebito();

	}

	/**
	 * Diferença entre débitos e créditos.
	 *
	 * Deve ser ZERO em um lançamento válido.
	 */
	public BigDecimal valorLiquido() {

		return totalDebito()

				.subtract(totalCredito());

	}

	/**
	 * Regra fundamental da contabilidade.
	 */
	public boolean partidaDobradaValida() {

		return valorLiquido()

				.compareTo(BigDecimal.ZERO) == 0;

	}

	/*
	 * ====================================== VALIDAÇÕES
	 * ======================================
	 */

	public void validar() {

		if (data == null) {

			throw new IllegalStateException("Data obrigatória");

		}

		if (documento == null || documento.isBlank()) {

			throw new IllegalStateException("Documento obrigatório");

		}

		if (historico == null || historico.isBlank()) {

			throw new IllegalStateException("Histórico obrigatório");

		}

		if (itens.isEmpty()) {

			throw new IllegalStateException("Lançamento sem itens");

		}

		for (ItemLancamento item : itens) {

			item.validar();

		}

		if (!partidaDobradaValida()) {

			throw new IllegalStateException("Débito deve ser igual ao crédito");

		}

	}

	public void validarParaPostagem() {

		validar();

		if (status != StatusLancamento.RASCUNHO && status != StatusLancamento.VALIDADO) {

			throw new IllegalStateException("Somente lançamentos em rascunho ou validados podem ser postados");

		}

	}

	public void validarAlteracao() {

		if (estaPostado()) {

			throw new IllegalStateException("Lançamento postado não pode ser alterado");

		}

		if (estaCancelado()) {

			throw new IllegalStateException("Lançamento cancelado não pode ser alterado");

		}

	}

	/*
	 * ====================================== CICLO DE VIDA
	 * ======================================
	 */

	public void validarLancamento() {

		validar();

		status = StatusLancamento.VALIDADO;

	}

	public void postar() {

		validarParaPostagem();

		status = StatusLancamento.POSTADO;

	}

	public void cancelar(String motivo) {

		if (!estaPostado()) {

			throw new IllegalStateException("Somente lançamento postado pode ser cancelado");

		}

		if (motivo == null || motivo.isBlank()) {

			throw new IllegalArgumentException("Motivo do cancelamento obrigatório");

		}

		status = StatusLancamento.CANCELADO;

		dataCancelamento = LocalDate.now();

		motivoCancelamento = motivo;

	}

	/*
	 * ====================================== EQUALS / HASHCODE
	 * ======================================
	 */

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {

			return true;

		}

		if (!(obj instanceof LancamentoContabil outro)) {

			return false;

		}

		if (getId() == null || outro.getId() == null) {

			return false;

		}

		return Objects.equals(getId(), outro.getId());

	}

	@Override
	public int hashCode() {

		if (getId() == null) {

			return System.identityHashCode(this);

		}

		return Objects.hash(getId());

	}

	/*
	 * ====================================== TO STRING
	 * ======================================
	 */

	@Override
	public String toString() {

		StringBuilder itensTexto = new StringBuilder();

		for (ItemLancamento item : itens) {

			itensTexto

					.append(item)

					.append(System.lineSeparator());

		}

		return """

				==========================================
				       LANÇAMENTO CONTÁBIL
				==========================================
				ID................: %s
				Data..............: %s
				Documento.........: %s
				Histórico.........: %s

				Status............: %s

				Débitos...........: R$ %s
				Créditos..........: R$ %s
				Valor Lançamento..: R$ %s

				Quantidade Itens..: %d

				------------------------------------------
				ITENS
				------------------------------------------
				%s
				==========================================

				"""

				.formatted(

						getId(),

						data,

						documento,

						historico,

						status,

						totalDebito(),

						totalCredito(),

						valorLancamento(),

						quantidadeItens(),

						itensTexto

				);

	}

}