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

        return itens;

    }





    public void adicionarItem(
            ItemLancamento item) {


        Objects.requireNonNull(
                item,
                "Item obrigatório"
        );


        itens.add(item);


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





    public boolean partidaDobradaValida() {


        return totalDebito()

                .compareTo(totalCredito())

                == 0;


    }





    public void imprimir() {


        System.out.println(
                data
                + " - "
                + documento
                + " - "
                + historico
        );


        itens.forEach(

                item ->

                    System.out.println(
                            "   " + item
                    )

        );


        System.out.println(
                "Débito: "
                + totalDebito()
        );


        System.out.println(
                "Crédito: "
                + totalCredito()
        );


    }



	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}



}