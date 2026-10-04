package exercicios04102026parte0.oo.exercicio2;

import java.util.List;

public class RelatorioService {

    public void imprimir(
            List<Transacao> transacoes) {

        transacoes.stream()
                .sorted(
                        (a, b) ->
                                b.valor()
                                        .compareTo(a.valor())
                )
                .forEach(t ->
                        System.out.println(
                                t.conta()
                                        .getCliente()
                                        .nome()
                                        + " | "
                                        + t.tipo()
                                        + " | "
                                        + t.valor()
                                        + " | "
                                        + t.status()
                        )
                );
    }
}