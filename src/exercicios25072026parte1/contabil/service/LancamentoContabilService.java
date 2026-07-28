package exercicios25072026parte1.contabil.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
        this.planoContaRepository = planoContaRepository;

    }

    public void salvar(
            LancamentoContabil lancamento) {

        validar(lancamento);

        atualizarSaldo(lancamento);

        repository.salvar(lancamento);

    }

    public Optional<LancamentoContabil> buscar(
            Integer id) {

        return repository.buscar(id);

    }

    public List<LancamentoContabil> listar() {

        return repository.listarOrdenado(

                Comparator.comparing(
                        LancamentoContabil::getData
                )

        );

    }

    public List<LancamentoContabil> listarPeriodo(
            LocalDate inicio,
            LocalDate fim) {

        return repository.listar()

                .stream()

                .filter(lancamento ->

                        !lancamento.getData().isBefore(inicio)

                        &&

                        !lancamento.getData().isAfter(fim))

                .toList();

    }

    public BigDecimal totalDebitos() {

        return repository.listar()

                .stream()

                .map(LancamentoContabil::totalDebito)

                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    public BigDecimal totalCreditos() {

        return repository.listar()

                .stream()

                .map(LancamentoContabil::totalCredito)

                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    public void remover(
            Integer id) {

        LancamentoContabil lancamento =

                repository.buscar(id)

                        .orElseThrow(() ->

                                new RuntimeException(
                                        "Lançamento não encontrado"
                                ));

        reverterSaldo(lancamento);

        repository.removerPorId(id);

    }

    private void validar(
            LancamentoContabil lancamento) {

        if (lancamento == null) {

            throw new RuntimeException(
                    "Lançamento obrigatório"
            );

        }

        if (lancamento.getData() == null) {

            throw new RuntimeException(
                    "Data obrigatória"
            );

        }

        if (lancamento.getItens() == null
                || lancamento.getItens().isEmpty()) {

            throw new RuntimeException(
                    "Lançamento sem itens"
            );

        }

        validarItens(lancamento);

        if (!lancamento.partidaDobradaValida()) {

            throw new RuntimeException(
                    "Débito deve ser igual ao crédito"
            );

        }

    }

    private void validarItens(
            LancamentoContabil lancamento) {

        boolean possuiDebito = false;
        boolean possuiCredito = false;

        for (ItemLancamento item : lancamento.getItens()) {

            if (item == null) {

                throw new RuntimeException(
                        "Item inválido"
                );

            }

            PlanoConta conta = item.getConta();

            if (conta == null) {

                throw new RuntimeException(
                        "Conta obrigatória"
                );

            }

            PlanoConta contaRepositorio =

                    planoContaRepository

                            .buscar(conta.getId())

                            .orElseThrow(() ->

                                    new RuntimeException(

                                            "Conta inexistente: "
                                                    + conta.getCodigo()

                                    ));

            if (!contaRepositorio.isAnalitica()) {

                throw new RuntimeException(

                        "Somente contas analíticas recebem lançamento: "
                                + contaRepositorio.getCodigo()

                );

            }

            if (item.getValor() == null
                    || item.getValor().compareTo(BigDecimal.ZERO) <= 0) {

                throw new RuntimeException(
                        "Valor inválido"
                );

            }

            if (item.isDebito()) {
                possuiDebito = true;
            }

            if (item.isCredito()) {
                possuiCredito = true;
            }

        }

        if (!possuiDebito) {

            throw new RuntimeException(
                    "Não existe débito"
            );

        }

        if (!possuiCredito) {

            throw new RuntimeException(
                    "Não existe crédito"
            );

        }

    }

    private void atualizarSaldo(
            LancamentoContabil lancamento) {

        for (ItemLancamento item : lancamento.getItens()) {

            PlanoConta conta =

                    planoContaRepository

                            .buscar(item.getConta().getId())

                            .orElseThrow();

            BigDecimal saldo = conta.getSaldo();

            if (item.isDebito()) {

                conta.setSaldo(
                        saldo.add(item.getValor())
                );

            } else {

                conta.setSaldo(
                        saldo.subtract(item.getValor())
                );

            }

        }

    }

    private void reverterSaldo(
            LancamentoContabil lancamento) {

        for (ItemLancamento item : lancamento.getItens()) {

            PlanoConta conta =

                    planoContaRepository

                            .buscar(item.getConta().getId())

                            .orElseThrow();

            BigDecimal saldo = conta.getSaldo();

            if (item.isDebito()) {

                conta.setSaldo(
                        saldo.subtract(item.getValor())
                );

            } else {

                conta.setSaldo(
                        saldo.add(item.getValor())
                );

            }

        }

    }

}