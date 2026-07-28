package exercicios25072026parte1.contabil.service;


import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import exercicios25072026parte1.contabil.enums.StatusLancamento;
import exercicios25072026parte1.contabil.model.ItemLancamento;
import exercicios25072026parte1.contabil.model.LancamentoContabil;
import exercicios25072026parte1.contabil.model.PlanoConta;
import exercicios25072026parte1.contabil.repository.LancamentoRepository;
import exercicios25072026parte1.contabil.repository.PlanoContaRepository;



public class LancamentoContabilService {


    private final LancamentoRepository repository;


    private final PlanoContaRepository planoContaRepository;




    public LancamentoContabilService(
            LancamentoRepository repository,
            PlanoContaRepository planoContaRepository) {


        this.repository = repository;

        this.planoContaRepository =
                planoContaRepository;

    }







    /**
     * Salva lançamento em rascunho.
     */
    public void salvar(
            LancamentoContabil lancamento) {


        if(lancamento == null) {

            throw new IllegalArgumentException(
                    "Lançamento obrigatório"
            );

        }


        if(lancamento.getStatus() == null) {

            lancamento.setStatus(
                    StatusLancamento.RASCUNHO
            );

        }


        repository.salvar(lancamento);

    }








    /**
     * Valida partida dobrada.
     */
    public void validar(
            Integer id) {


        LancamentoContabil lancamento =
                buscarObrigatorio(id);



        validarContas(lancamento);



        lancamento.validarLancamento();



        repository.salvar(lancamento);

    }








    /**
     * Posta na contabilidade.
     */
    public void postar(
            Integer id) {


        LancamentoContabil lancamento =
                buscarObrigatorio(id);



        if(lancamento.getStatus()
                != StatusLancamento.VALIDADO) {


            throw new IllegalStateException(

                    "Somente lançamento validado pode ser postado"

            );

        }




        atualizarSaldo(lancamento);



        lancamento.postar();



        repository.salvar(lancamento);

    }








    /**
     * Cancela lançamento postado.
     */
    public void cancelar(
            Integer id,
            String motivo) {


        LancamentoContabil lancamento =
                buscarObrigatorio(id);




        reverterSaldo(lancamento);



        lancamento.cancelar(
                motivo
        );



        repository.salvar(lancamento);

    }








    public Optional<LancamentoContabil> buscar(
            Integer id) {


        return repository.buscar(id);

    }








    private LancamentoContabil buscarObrigatorio(
            Integer id) {


        return repository.buscar(id)

                .orElseThrow(

                        () -> new RuntimeException(

                                "Lançamento não encontrado: "
                                        + id

                        )

                );

    }








    public List<LancamentoContabil> listar() {


        return repository.listarOrdenado(

                Comparator.comparing(

                        LancamentoContabil::getData

                )

        );

    }








    public List<LancamentoContabil> listarPostados() {


        return repository.listar()

                .stream()

                .filter(

                        l -> l.getStatus()
                                ==
                                StatusLancamento.POSTADO

                )

                .toList();

    }








    public BigDecimal totalDebitos() {


        return listarPostados()

                .stream()

                .map(
                        LancamentoContabil::totalDebito
                )

                .reduce(

                        BigDecimal.ZERO,

                        BigDecimal::add

                );

    }








    public BigDecimal totalCreditos() {


        return listarPostados()

                .stream()

                .map(
                        LancamentoContabil::totalCredito
                )

                .reduce(

                        BigDecimal.ZERO,

                        BigDecimal::add

                );

    }









    private void validarContas(
            LancamentoContabil lancamento) {


        lancamento.validar();



        for(ItemLancamento item :
                lancamento.getItens()) {


            PlanoConta conta =

                    planoContaRepository

                            .buscar(
                                    item.getConta().getId()
                            )

                            .orElseThrow(

                                    () -> new RuntimeException(

                                            "Conta não encontrada"

                                    )

                            );



            if(!conta.isAnalitica()) {


                throw new IllegalStateException(

                        "Conta sintética não aceita lançamento: "
                                + conta.getCodigo()

                );

            }

        }


    }








    private void atualizarSaldo(
            LancamentoContabil lancamento) {



        for(ItemLancamento item :
                lancamento.getItens()) {


            PlanoConta conta =

                    planoContaRepository

                            .buscar(
                                    item.getConta().getId()
                            )

                            .orElseThrow();



            BigDecimal saldo =

                    conta.getSaldo() == null

                            ?

                            BigDecimal.ZERO

                            :

                            conta.getSaldo();




            if(item.isDebito()) {


                conta.setSaldo(

                        saldo.add(
                                item.getValor()
                        )

                );


            } else {


                conta.setSaldo(

                        saldo.subtract(
                                item.getValor()
                        )

                );

            }


        }

    }








    private void reverterSaldo(
            LancamentoContabil lancamento) {



        for(ItemLancamento item :
                lancamento.getItens()) {


            PlanoConta conta =

                    planoContaRepository

                            .buscar(
                                    item.getConta().getId()
                            )

                            .orElseThrow();



            BigDecimal saldo =

                    conta.getSaldo() == null

                            ?

                            BigDecimal.ZERO

                            :

                            conta.getSaldo();




            if(item.isDebito()) {


                conta.setSaldo(

                        saldo.subtract(
                                item.getValor()
                        )

                );


            } else {


                conta.setSaldo(

                        saldo.add(
                                item.getValor()
                        )

                );

            }

        }

    }


}