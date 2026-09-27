package exercicios26092026parte0.oo.exercicio2;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class MainTestes {

    public static void main(String[] args) {

        List<Transacao> transacoes = List.of(
                new Transacao("PIX", new BigDecimal("150.00")),
                new Transacao("BOLETO", new BigDecimal("300.00")),
                new Transacao("PIX", new BigDecimal("50.00")),
                new Transacao("CARTAO", new BigDecimal("1200.00"))
        );

        ProcessadorTransacoes processador =
                new ProcessadorTransacoes();

        Map<String, List<Transacao>> agrupado =
                processador.agruparPorTipo(transacoes);

        agrupado.forEach((tipo, listaTransacoes) -> {
            System.out.println("Tipo: " + tipo);

            listaTransacoes.forEach(
                    transacao -> System.out.println("  " + transacao)
            );
        });
    }
}