package exercicios26092026parte0.oo.exercicio2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProcessadorTransacoes {

    public Map<String, List<Transacao>> agruparPorTipo(
            List<Transacao> transacoes) {

        return transacoes.stream()
                .collect(Collectors.groupingBy(Transacao::getTipo));
    }
}