package exercicios25072026parte1.contabil.model;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class LancamentoContabil extends Entidade<Integer> {



    private static final long serialVersionUID = 1L;



    private LocalDate data;



    private String documento;



    private String historico;



    private final List<ItemLancamento> itens =
            new ArrayList<>();





    public LancamentoContabil() {

    }






    public LancamentoContabil(
            Integer id,
            LocalDate data,
            String documento,
            String historico) {


        setId(id);

        this.data = data;
        this.documento = documento;
        this.historico = historico;

    }







    public LocalDate getData() {

        return data;

    }



    public void setData(LocalDate data) {

        this.data = data;

    }







    public String getDocumento() {

        return documento;

    }



    public void setDocumento(String documento) {

        this.documento = documento;

    }







    public String getHistorico() {

        return historico;

    }



    public void setHistorico(String historico) {

        this.historico = historico;

    }







    public List<ItemLancamento> getItens() {


        return List.copyOf(itens);

    }







    public void adicionarItem(
            ItemLancamento item) {



        Objects.requireNonNull(
                item,
                "Item de lançamento obrigatório"
        );



        itens.add(item);

    }







    public void removerItem(
            ItemLancamento item) {


        itens.remove(item);

    }







    public boolean possuiItens() {


        return !itens.isEmpty();

    }







    public BigDecimal totalDebito() {


        return itens.stream()

                .filter(ItemLancamento::isDebito)

                .map(ItemLancamento::getValor)

                .filter(Objects::nonNull)

                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );

    }







    public BigDecimal totalCredito() {


        return itens.stream()

                .filter(ItemLancamento::isCredito)

                .map(ItemLancamento::getValor)

                .filter(Objects::nonNull)

                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );

    }







    public boolean partidaDobradaValida() {


        return totalDebito()

                .compareTo(
                        totalCredito()
                )

                == 0;

    }







    public boolean validar() {


        if(data == null) {

            return false;

        }


        if(itens.isEmpty()) {

            return false;

        }


        return itens.stream()

                .allMatch(
                        ItemLancamento::valido
                );

    }







    public void imprimir() {



        System.out.println("--------------------------------");

        System.out.println(
                "Data......: "
                + data
        );


        System.out.println(
                "Documento.: "
                + documento
        );


        System.out.println(
                "Histórico.: "
                + historico
        );


        System.out.println("--------------------------------");



        itens.forEach(

                item ->
                        System.out.println(
                                "   "
                                + item
                        )

        );



        System.out.println("--------------------------------");



        System.out.println(
                "Débito....: R$ "
                + totalDebito()
        );



        System.out.println(
                "Crédito...: R$ "
                + totalCredito()
        );



        System.out.println(
                "Válido....: "
                + partidaDobradaValida()
        );


        System.out.println("--------------------------------");

    }







    @Override
    public String toString() {


        return data
                + " | "
                + documento
                + " | "
                + historico
                + " | Débito R$ "
                + totalDebito()
                + " | Crédito R$ "
                + totalCredito();

    }



}