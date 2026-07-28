package exercicios25072026parte1.contabil.relatorio;


import java.math.BigDecimal;

import exercicios25072026parte1.contabil.model.CentroCusto;



public class CentroCustoRelatorio {


    private final CentroCusto centroCusto;


    private final BigDecimal totalDebito;


    private final BigDecimal totalCredito;


    private final BigDecimal saldo;



    public CentroCustoRelatorio(

            CentroCusto centroCusto,

            BigDecimal totalDebito,

            BigDecimal totalCredito,

            BigDecimal saldo

    ) {

        this.centroCusto = centroCusto;
        this.totalDebito = totalDebito;
        this.totalCredito = totalCredito;
        this.saldo = saldo;

    }





    public CentroCusto getCentroCusto() {

        return centroCusto;

    }





    public BigDecimal getTotalDebito() {

        return totalDebito;

    }





    public BigDecimal getTotalCredito() {

        return totalCredito;

    }





    public BigDecimal getSaldo() {

        return saldo;

    }






    @Override
    public String toString() {


        return String.format(

                "%s | Débito: R$ %s | Crédito: R$ %s | Saldo: R$ %s",

                centroCusto.getDescricao(),

                totalDebito,

                totalCredito,

                saldo

        );

    }


}