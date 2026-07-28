package exercicios25072026parte1.contabil.relatorio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import exercicios25072026parte1.contabil.model.ItemLancamento;
import exercicios25072026parte1.contabil.enums.TipoMovimento;


public class LivroDiarioRelatorio {


    private final LocalDate data;

    private final String documento;

    private final String historico;

    private final List<ItemLancamento> itens;





    public LivroDiarioRelatorio(

            LocalDate data,

            String documento,

            String historico,

            List<ItemLancamento> itens

    ) {

        this.data = data;
        this.documento = documento;
        this.historico = historico;
        this.itens = itens;

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



    public List<ItemLancamento> getItens() {

        return itens;

    }







    public BigDecimal totalDebito() {


        return itens.stream()

                .filter(ItemLancamento::isDebito)

                .map(ItemLancamento::getValor)

                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );

    }







    public BigDecimal totalCredito() {


        return itens.stream()

                .filter(ItemLancamento::isCredito)

                .map(ItemLancamento::getValor)

                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );

    }







    public boolean partidaDobradaOk() {


        return totalDebito()

                .compareTo(
                        totalCredito()
                )

                == 0;

    }








    @Override
    public String toString() {


        StringBuilder sb = new StringBuilder();



        sb.append("\n");
        sb.append("========================================\n");
        sb.append("             LIVRO DIÁRIO\n");
        sb.append("========================================\n");

        sb.append("Data: ")
                .append(data)
                .append("\n");


        sb.append("Documento: ")
                .append(documento)
                .append("\n");


        sb.append("Histórico: ")
                .append(historico)
                .append("\n\n");



        itens.forEach(item -> {


            String tipo =

                    item.getMovimento()
                            == TipoMovimento.DEBITO

                            ?

                            "D"

                            :

                            "C";



            sb.append(tipo)
                    .append(" - ")
                    .append(item.getConta().getCodigo())
                    .append(" ")
                    .append(item.getConta().getDescricao())

                    .append("  R$ ")

                    .append(item.getValor())

                    .append("\n");


        });



        sb.append("\n");

        sb.append("Débito:  R$ ")
                .append(totalDebito())
                .append("\n");


        sb.append("Crédito: R$ ")
                .append(totalCredito())
                .append("\n");



        sb.append("\nPartida dobrada: ")


                .append(

                        partidaDobradaOk()

                                ?

                                "OK"

                                :

                                "ERRO"

                );


        sb.append("\n");

        sb.append("========================================\n");



        return sb.toString();

    }


}