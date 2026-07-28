package exercicios25072026parte1.contabil.service;


import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import exercicios25072026parte1.contabil.enums.StatusLancamento;
import exercicios25072026parte1.contabil.model.LancamentoContabil;
import exercicios25072026parte1.contabil.relatorio.LivroDiarioRelatorio;



public class LivroDiarioService {


    private final LancamentoContabilService lancamentoService;




    public LivroDiarioService(
            LancamentoContabilService lancamentoService) {

        this.lancamentoService =
                lancamentoService;

    }








    /**
     * Gera Livro Diário completo.
     */
    public List<LivroDiarioRelatorio> gerar() {


        return lancamentoService.listar()

                .stream()

                .filter(

                        lancamento ->

                        lancamento.getStatus()
                                ==
                        StatusLancamento.POSTADO

                )

                .map(

                        this::converter

                )

                .sorted(

                        Comparator.comparing(

                                LivroDiarioRelatorio::getData

                        )

                )

                .toList();

    }









    /**
     * Livro Diário por período.
     */
    public List<LivroDiarioRelatorio> gerarPeriodo(

            LocalDate inicio,

            LocalDate fim

    ) {


        Objects.requireNonNull(
                inicio,
                "Data inicial obrigatória"
        );


        Objects.requireNonNull(
                fim,
                "Data final obrigatória"
        );



        return gerar()

                .stream()

                .filter(

                        rel ->

                        !rel.getData()
                                .isBefore(inicio)

                        &&

                        !rel.getData()
                                .isAfter(fim)

                )

                .toList();

    }











    /**
     * Gera um lançamento específico.
     */
    public LivroDiarioRelatorio gerarLancamento(
            Integer id) {


        LancamentoContabil lancamento =

                lancamentoService.buscar(id)

                .orElseThrow(

                        () -> new RuntimeException(

                                "Lançamento não encontrado: "
                                        + id

                        )

                );



        if(lancamento.getStatus()
                != StatusLancamento.POSTADO) {


            throw new IllegalStateException(

                    "Somente lançamentos postados aparecem no Livro Diário"

            );

        }



        return converter(
                lancamento
        );

    }









    private LivroDiarioRelatorio converter(

            LancamentoContabil lancamento

    ) {


        return new LivroDiarioRelatorio(

                lancamento.getData(),

                lancamento.getDocumento(),

                lancamento.getHistorico(),

                lancamento.getItens()

        );

    }


}