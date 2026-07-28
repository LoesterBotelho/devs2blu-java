package exercicios25072026parte1.contabil.model;


import java.util.Objects;



public class CentroCusto extends Entidade<Integer> {


    private static final long serialVersionUID = 1L;



    private String codigo;


    private String descricao;


    private boolean ativo;







    public CentroCusto() {

    }







    public CentroCusto(
            Integer id,
            String codigo,
            String descricao) {


        setId(id);

        this.codigo = codigo;
        this.descricao = descricao;
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







    public boolean isAtivo() {

        return ativo;

    }



    public void setAtivo(boolean ativo) {

        this.ativo = ativo;

    }







    @Override
    public boolean equals(Object obj) {


        if(this == obj) {

            return true;

        }



        if(!(obj instanceof CentroCusto outro)) {

            return false;

        }



        return Objects.equals(
                getId(),
                outro.getId()
        );

    }







    @Override
    public int hashCode() {


        return Objects.hash(
                getId()
        );

    }







    @Override
    public String toString() {


        return codigo
                + " - "
                + descricao;

    }


}