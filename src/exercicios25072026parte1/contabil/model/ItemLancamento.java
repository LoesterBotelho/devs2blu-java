package exercicios25072026parte1.contabil.model;


import java.math.BigDecimal;
import java.util.Objects;

import exercicios25072026parte1.contabil.enums.TipoMovimento;



public class ItemLancamento extends Entidade<Integer> {



    private static final long serialVersionUID = 1L;



    private PlanoConta conta;



    private CentroCusto centroCusto;



    private TipoMovimento movimento;



    private BigDecimal valor;







    public ItemLancamento() {

    }







    public ItemLancamento(
            Integer id,
            PlanoConta conta,
            CentroCusto centroCusto,
            TipoMovimento movimento,
            BigDecimal valor) {


        setId(id);

        this.conta = conta;
        this.centroCusto = centroCusto;
        this.movimento = movimento;
        this.valor = valor;

    }







    public ItemLancamento(
            PlanoConta conta,
            TipoMovimento movimento,
            BigDecimal valor) {


        this.conta = conta;
        this.movimento = movimento;
        this.valor = valor;

    }







    public PlanoConta getConta() {

        return conta;

    }



    public void setConta(PlanoConta conta) {

        this.conta = conta;

    }







    public CentroCusto getCentroCusto() {

        return centroCusto;

    }



    public void setCentroCusto(
            CentroCusto centroCusto) {

        this.centroCusto = centroCusto;

    }







    public TipoMovimento getMovimento() {

        return movimento;

    }



    public void setMovimento(
            TipoMovimento movimento) {

        this.movimento = movimento;

    }







    public BigDecimal getValor() {

        return valor;

    }



    public void setValor(BigDecimal valor) {

        this.valor = valor;

    }







    public boolean isDebito() {


        return movimento == TipoMovimento.DEBITO;

    }







    public boolean isCredito() {


        return movimento == TipoMovimento.CREDITO;

    }







    public BigDecimal valorAbsoluto() {


        if(valor == null) {

            return BigDecimal.ZERO;

        }


        return valor.abs();

    }







    public boolean valido() {


        return conta != null

                && movimento != null

                && valor != null

                && valor.compareTo(
                        BigDecimal.ZERO
                ) > 0;

    }







    @Override
    public String toString() {


        return movimento
                + " | "
                + conta
                + " | R$ "
                + valor;

    }







    @Override
    public boolean equals(Object obj) {


        if(this == obj) {

            return true;

        }



        if(!(obj instanceof ItemLancamento outro)) {

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


}