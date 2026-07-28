package exercicios25072026parte1.contabil.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import exercicios25072026parte1.contabil.enums.TipoCentroCusto;

public class CentroCusto extends Entidade<Integer> implements Comparable<CentroCusto> {

	private static final long serialVersionUID = 1L;

    private Integer id;
	private String codigo;

	private String descricao;

	private TipoCentroCusto tipo;

	private boolean ativo;

	private CentroCusto pai;

	private final List<CentroCusto> filhos = new ArrayList<>();

	private BigDecimal percentualRateio = BigDecimal.ZERO;

	public CentroCusto() {

	}

	public CentroCusto(Integer id, String codigo, String descricao, TipoCentroCusto tipo) {

		setId(id);

		this.codigo = codigo;
		this.descricao = descricao;
		this.tipo = tipo;
		this.ativo = true;

	}

	public String getCodigo() {

		return codigo;

	}

	public void setCodigo(String codigo) {

		this.codigo = codigo;

	}

	public String getDescricao() {

		return descricao;

	}

	public void setDescricao(String descricao) {

		this.descricao = descricao;

	}

	public TipoCentroCusto getTipo() {

		return tipo;

	}

	public void setTipo(TipoCentroCusto tipo) {

		this.tipo = tipo;

	}

	public boolean isAtivo() {

		return ativo;

	}

	public void setAtivo(boolean ativo) {

		this.ativo = ativo;

	}

	public CentroCusto getPai() {

		return pai;

	}

	public void setPai(CentroCusto pai) {

		this.pai = pai;

	}

	public List<CentroCusto> getFilhos() {

		return Collections.unmodifiableList(filhos);

	}

	public BigDecimal getPercentualRateio() {

		return percentualRateio;

	}

	public void setPercentualRateio(BigDecimal percentualRateio) {

		this.percentualRateio = percentualRateio == null ? BigDecimal.ZERO : percentualRateio;

	}

	public void adicionarFilho(CentroCusto filho) {

		Objects.requireNonNull(filho, "Centro custo filho obrigatório");

		filho.setPai(this);

		if (!filhos.contains(filho)) {

			filhos.add(filho);

		}

	}

	public void removerFilho(CentroCusto filho) {

		if (filho == null) {

			return;

		}

		if (filhos.remove(filho)) {

			filho.setPai(null);

		}

	}

	public boolean possuiFilhos() {

		return !filhos.isEmpty();

	}

	public int quantidadeFilhos() {

		return filhos.size();

	}

	public boolean isAnalitico() {

		return tipo == TipoCentroCusto.ANALITICO;

	}

	public boolean isSintetico() {

		return tipo == TipoCentroCusto.SINTETICO;

	}

	public BigDecimal percentualTotalFilhos() {

		return filhos.stream()

				.map(CentroCusto::getPercentualRateio)

				.reduce(BigDecimal.ZERO, BigDecimal::add);

	}

	public boolean rateioValido() {

		return percentualTotalFilhos()

				.compareTo(BigDecimal.valueOf(100)) == 0;

	}

	public CentroCusto localizar(String codigo) {

		return filhos.stream()

				.filter(

						filho -> Objects.equals(filho.getCodigo(), codigo)

				)

				.findFirst()

				.orElse(null);

	}

	public CentroCusto localizarRecursivo(String codigo) {

		if (Objects.equals(this.codigo, codigo)) {

			return this;

		}

		for (CentroCusto filho : filhos) {

			CentroCusto encontrado = filho.localizarRecursivo(codigo);

			if (encontrado != null) {

				return encontrado;

			}

		}

		return null;

	}

	public void imprimir(String espacos) {

		System.out.println(

				espacos + codigo + " - " + descricao + " (" + percentualRateio + "%)"

		);

		filhos.forEach(

				filho ->

				filho.imprimir(espacos + "    ")

		);

	}

	@Override
	public int compareTo(CentroCusto outro) {

		return this.codigo.compareToIgnoreCase(outro.codigo);

	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {

			return true;

		}

		if (!(obj instanceof CentroCusto outro)) {

			return false;

		}

		return Objects.equals(getId(), outro.getId());

	}

	@Override
	public int hashCode() {

		return Objects.hash(getId());

	}

	@Override
	public String toString() {

		return codigo + " - " + descricao;

	}

	@Override
	public void setId(Integer id) {

		this.id = id;

	}

	@Override
	public Integer getId() {

		return id;

	}

}