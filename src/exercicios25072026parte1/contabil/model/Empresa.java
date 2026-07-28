package exercicios25072026parte1.contabil.model;

import java.util.Objects;

public class Empresa extends Entidade<Integer>
        implements Comparable<Empresa> {

	private static final long serialVersionUID = 7485002786998892365L;
	private Integer codigo;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private boolean ativa;

    public Empresa() {

    }

    public Empresa(Integer codigo,
                   String razaoSocial,
                   String nomeFantasia,
                   String cnpj,
                   boolean ativa) {

        this.codigo = codigo;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.ativa = ativa;

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

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    @Override
    public int compareTo(Empresa o) {
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

        if (!(obj instanceof Empresa other))
            return false;

        return Objects.equals(codigo, other.codigo);

    }

    @Override
    public String toString() {

        return String.format("%04d - %s",
                codigo,
                razaoSocial);

    }

}