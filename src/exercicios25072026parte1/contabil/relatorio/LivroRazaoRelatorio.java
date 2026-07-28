package exercicios25072026parte1.contabil.relatorio;


import java.math.BigDecimal;
import java.time.LocalDate;

import exercicios25072026parte1.contabil.enums.TipoMovimento;


public class LivroRazaoRelatorio {


    private final LocalDate data;

    private final String documento;

    private final String historico;

    private final TipoMovimento movimento;

    private final BigDecimal debito;

    private final BigDecimal credito;

    private final BigDecimal saldo;




    public LivroRazaoRelatorio(

            LocalDate data,

            String documento,

            String historico,

            TipoMovimento movimento,

            BigDecimal debito,

            BigDecimal credito,

            BigDecimal saldo

    ) {

        this.data = data;
        this.documento = documento;
        this.historico = historico;
        this.movimento = movimento;
        this.debito = debito;
        this.credito = credito;
        this.saldo = saldo;

    }





    public LocalDate getData() {
        return data;
    }



    public String getDocumento() {
        return documento;
    }



    public String getHistorico() {
        return historico;
    }



    public TipoMovimento getMovimento() {
        return movimento;
    }



    public BigDecimal getDebito() {
        return debito;
    }



    public BigDecimal getCredito() {
        return credito;
    }



    public BigDecimal getSaldo() {
        return saldo;
    }






    @Override
    public String toString() {


        return String.format(

                "%s | %-10s | %-25s | D: %10s | C: %10s | Saldo: %10s",

                data,

                documento,

                historico,

                debito,

                credito,

                saldo

        );

    }


}