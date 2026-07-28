package exercicios25072026parte1.contabil.relatorio;


import java.math.BigDecimal;

import exercicios25072026parte1.contabil.model.CentroCusto;


public class CentroCustoRelatorio {


    private final CentroCusto centroCusto;


    private final BigDecimal totalDebito;



    public CentroCustoRelatorio(
            CentroCusto centroCusto,
            BigDecimal totalDebito) {


        this.centroCusto = centroCusto;

        this.totalDebito = totalDebito;

    }





    public CentroCusto getCentroCusto() {

        return centroCusto;

    }




    public BigDecimal getTotalDebito() {

        return totalDebito;

    }





    @Override
    public String toString() {


        return

        "Centro Custo: "

        + centroCusto.getCodigo()

        + " - "

        + centroCusto.getDescricao()

        + " | Total: R$ "

        + totalDebito;


    }


}