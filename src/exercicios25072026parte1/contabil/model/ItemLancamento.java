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


    /**
     * Lançamento contábil ao qual pertence
     */
    private LancamentoContabil lancamento;





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

        setValor(valor);

    }








    public ItemLancamento(
            PlanoConta conta,
            CentroCusto centroCusto,
            TipoMovimento movimento,
            BigDecimal valor) {


        this.conta = conta;

        this.centroCusto = centroCusto;

        this.movimento = movimento;

        setValor(valor);

    }







    public PlanoConta getConta() {

        return conta;

    }



    public void setConta(
            PlanoConta conta) {

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



    public void setValor(
            BigDecimal valor) {


        this.valor = valor == null

                ? BigDecimal.ZERO

                : valor;

    }







    public LancamentoContabil getLancamento() {

        return lancamento;

    }



    public void setLancamento(
            LancamentoContabil lancamento) {

        this.lancamento = lancamento;

    }







    public boolean isDebito() {

        return movimento == TipoMovimento.DEBITO;

    }







    public boolean isCredito() {

        return movimento == TipoMovimento.CREDITO;

    }







    public boolean possuiCentroCusto() {

        return centroCusto != null;

    }







    public BigDecimal valorAbsoluto() {

        return valor == null

                ? BigDecimal.ZERO

                : valor.abs();

    }







    public boolean pertenceAo(
            PlanoConta conta) {


        return this.conta != null

                && this.conta.equals(conta);

    }







    public boolean valido() {


        return conta != null

                && centroCusto != null

                && movimento != null

                && valor != null

                && valor.compareTo(
                        BigDecimal.ZERO
                ) > 0;

    }







    public void validar() {


        if(conta == null) {


            throw new IllegalStateException(
                    "Conta contábil obrigatória"
            );

        }





        if(centroCusto == null) {


            throw new IllegalStateException(
                    "Centro de custo obrigatório"
            );

        }





        if(movimento == null) {


            throw new IllegalStateException(
                    "Tipo de movimento obrigatório"
            );

        }





        if(valor == null

                || valor.compareTo(
                        BigDecimal.ZERO
                ) <= 0) {


            throw new IllegalStateException(
                    "Valor deve ser maior que zero"
            );

        }

    }







    @Override
    public String toString() {


        return """

                ITEM LANÇAMENTO
                -------------------------
                Conta.......: %s
                Centro Custo: %s
                Movimento...: %s
                Valor.......: R$ %s

                """
                .formatted(

                        conta,

                        centroCusto,

                        movimento,

                        valor

                );

    }







    @Override
    public boolean equals(Object obj) {


        if(this == obj) {

            return true;

        }



        if(!(obj instanceof ItemLancamento outro)) {

            return false;

        }



        if(getId() == null

                || outro.getId() == null) {

            return this == outro;

        }



        return Objects.equals(
                getId(),
                outro.getId()
        );

    }







    @Override
    public int hashCode() {


        return getId() == null

                ? System.identityHashCode(this)

                : Objects.hash(getId());

    }


}