package exercicios04102026parte0.oo.exercicio2;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Predicate;

public class TransacaoFilter {

    public Predicate<Transacao> aprovadas() {

        return transacao ->
                transacao.status() == StatusTransacao.APROVADA;
    }

    public Predicate<Transacao> acimaDe(
            BigDecimal valor) {

        return transacao ->
                transacao.valor()
                        .compareTo(valor) > 0;
    }

    public Predicate<Transacao> depoisDe(
            LocalDateTime data) {

        return transacao ->
                transacao.data().isAfter(data);
    }

    public Predicate<Transacao> tipo(
            TipoTransacao tipo) {

        return transacao ->
                transacao.tipo() == tipo;
    }
}