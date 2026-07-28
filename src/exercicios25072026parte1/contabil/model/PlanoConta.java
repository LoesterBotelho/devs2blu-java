package exercicios25072026parte1.contabil.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import exercicios25072026parte1.contabil.enums.NaturezaConta;
import exercicios25072026parte1.contabil.enums.TipoConta;

public class PlanoConta extends Entidade<Integer>
        implements Comparable<PlanoConta> {

	private static final long serialVersionUID = -6068578309356281375L;

	private Integer codigoInterno;

    private String codigo;

    private String descricao;

    private NaturezaConta natureza;

    private TipoConta tipoConta;

    private Integer nivel;

    private boolean aceitaLancamento;

    private boolean ativo;

    private PlanoConta contaPai;

    private final List<PlanoConta> contasFilhas = new ArrayList<>();

    private BigDecimal saldo = BigDecimal.ZERO;

    public PlanoConta() {

    }

    public PlanoConta(Integer codigoInterno,
                      String codigo,
                      String descricao,
                      NaturezaConta natureza,
                      TipoConta tipoConta,
                      Integer nivel,
                      boolean aceitaLancamento) {

        this.codigoInterno = codigoInterno;
        this.codigo = codigo;
        this.descricao = descricao;
        this.natureza = natureza;
        this.tipoConta = tipoConta;
        this.nivel = nivel;
        this.aceitaLancamento = aceitaLancamento;
        this.ativo = true;

    }

    @Override
    public Integer getId() {
        return codigoInterno;
    }

    public Integer getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(Integer codigoInterno) {
        this.codigoInterno = codigoInterno;
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

    public NaturezaConta getNatureza() {
        return natureza;
    }

    public void setNatureza(NaturezaConta natureza) {
        this.natureza = natureza;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public boolean isAceitaLancamento() {
        return aceitaLancamento;
    }

    public void setAceitaLancamento(boolean aceitaLancamento) {
        this.aceitaLancamento = aceitaLancamento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public PlanoConta getContaPai() {
        return contaPai;
    }

    public void setContaPai(PlanoConta contaPai) {
        this.contaPai = contaPai;
    }

    public List<PlanoConta> getContasFilhas() {
        return contasFilhas;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public int compareTo(PlanoConta o) {
        return codigo.compareTo(o.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoInterno);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof PlanoConta other))
            return false;

        return Objects.equals(codigoInterno,
                              other.codigoInterno);

    }

    @Override
    public String toString() {

        return codigo + " - " + descricao;

    }

}