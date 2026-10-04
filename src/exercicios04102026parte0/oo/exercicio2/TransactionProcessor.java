package exercicios04102026parte0.oo.exercicio2;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TransactionProcessor {

    public void processar(
            List<Transacao> transacoes,
            Predicate<Transacao> filtro,
            Consumer<Transacao> consumidor) {

        transacoes.stream()
                .filter(filtro)
                .forEach(consumidor);
    }
}