package exercicios25102026parte0.oo.exercicio1;

import java.util.Map;
import java.util.Set;

public class ValidadorEntrega {
    private final Map<StatusEntrega, Set<StatusEntrega>> transicoes =
            Map.of(
                    StatusEntrega.CRIADA,
                    Set.of(StatusEntrega.AGUARDANDO_COLETA, StatusEntrega.CANCELADA),

                    StatusEntrega.AGUARDANDO_COLETA,
                    Set.of(StatusEntrega.EM_TRANSITO, StatusEntrega.CANCELADA),

                    StatusEntrega.EM_TRANSITO,
                    Set.of(StatusEntrega.SAIU_PARA_ENTREGA, StatusEntrega.DEVOLVIDA),

                    StatusEntrega.SAIU_PARA_ENTREGA,
                    Set.of(StatusEntrega.ENTREGUE, StatusEntrega.DEVOLVIDA),

                    StatusEntrega.DEVOLVIDA,
                    Set.of(StatusEntrega.AGUARDANDO_COLETA)
            );

    public boolean podeTransicionar(
            StatusEntrega atual,
            StatusEntrega novo) {

        if (atual == null || novo == null || atual == novo) {
            return false;
        }

        return transicoes.getOrDefault(atual, Set.of()).contains(novo);
    }

    public void validarTransicao(
            StatusEntrega atual,
            StatusEntrega novo) {

        if (!podeTransicionar(atual, novo)) {
            throw new IllegalStateException(
                    "Transição de status não permitida: "
                            + atual + " para " + novo);
        }
    }
    
}