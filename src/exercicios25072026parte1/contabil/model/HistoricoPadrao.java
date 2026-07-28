package exercicios25072026parte1.contabil.model;

import java.util.Objects;

public class HistoricoPadrao extends Entidade<Integer>
        implements Comparable<HistoricoPadrao> {

	private static final long serialVersionUID = 7297805266880224686L;
	private Integer codigo;
    private String descricao;

    public HistoricoPadrao() {

    }

    public HistoricoPadrao(Integer codigo,
                           String descricao) {

        this.codigo = codigo;
        this.descricao = descricao;

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

    @Override
    public int compareTo(HistoricoPadrao o) {
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

        if (!(obj instanceof HistoricoPadrao other))
            return false;

        return Objects.equals(codigo, other.codigo);

    }

    @Override
    public String toString() {

        return codigo + " - " + descricao;

    }

}