package exercicios25072026parte1.contabil.relatorio;


import java.math.BigDecimal;

import exercicios25072026parte1.contabil.model.CentroCusto;



public class CentroCustoResumoRelatorio {


    private final CentroCusto centroCusto;


    private final BigDecimal total;




    public CentroCustoResumoRelatorio(
            CentroCusto centroCusto,
            BigDecimal total) {


        this.centroCusto = centroCusto;
        this.total = total;

    }





    public CentroCusto getCentroCusto() {

        return centroCusto;

    }





    public BigDecimal getTotal() {

        return total;

    }





    @Override
    public String toString() {


        return centroCusto
                +
                " => R$ "
                +
                total;

    }


}