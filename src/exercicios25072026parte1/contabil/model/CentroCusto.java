package exercicios25072026parte1.contabil.model;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class CentroCusto extends Entidade<Integer> {


    private static final long serialVersionUID = 1L;


    private String codigo;


    private String descricao;


    private CentroCusto centroPai;


    private final List<CentroCusto> filhos =
            new ArrayList<>();




    public CentroCusto() {

    }





    public CentroCusto(
            Integer id,
            String codigo,
            String descricao) {

        setId(id);

        this.codigo = codigo;
        this.descricao = descricao;

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




    public CentroCusto getCentroPai() {

        return centroPai;

    }




    public void setCentroPai(CentroCusto centroPai) {

        this.centroPai = centroPai;

    }




    public List<CentroCusto> getFilhos() {

        return List.copyOf(filhos);

    }





    public void adicionarFilho(
            CentroCusto filho) {


        if(filho == null) {

            throw new IllegalArgumentException(
                    "Centro custo obrigatório"
            );

        }


        filho.setCentroPai(this);

        filhos.add(filho);

    }





    public void ordenarFilhos() {


        filhos.sort(

                Comparator.comparing(
                        CentroCusto::getCodigo
                )

        );


    }





    @Override
    public String toString() {

        return codigo
                + " - "
                + descricao;

    }

}