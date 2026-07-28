package exercicios25072026parte1.contabil.model;

import java.util.Objects;

public class CentroCusto extends Entidade<Integer>
        implements Comparable<CentroCusto> {

	private static final long serialVersionUID = -3280217269844227645L;
	private Integer codigo;
    private String descricao;
    private boolean ativo;

    public CentroCusto() {

    }

    public CentroCusto(Integer codigo,
                       String descricao,
                       boolean ativo) {

        this.codigo = codigo;
        this.descricao = descricao;
        this.ativo = ativo;

    }

    @Override
    public Integer getId() {
        return codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int compareTo(CentroCusto o) {
        return codigo.compareTo(o.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof CentroCusto other))
            return false;

        return Objects.equals(codigo, other.codigo);

    }

    @Override
    public String toString() {

        return codigo + " - " + descricao;

    }

}