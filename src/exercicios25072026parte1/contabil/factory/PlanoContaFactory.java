package exercicios25072026parte1.contabil.factory;

import exercicios25072026parte1.contabil.enums.NaturezaConta;
import exercicios25072026parte1.contabil.enums.TipoConta;
import exercicios25072026parte1.contabil.model.PlanoConta;

public final class PlanoContaFactory {

    private static int sequencia = 1;

    private PlanoContaFactory() {
    }

    public static PlanoConta criarSintetica(
            String codigo,
            String descricao,
            NaturezaConta natureza,
            Integer nivel) {

        return criar(
                codigo,
                descricao,
                natureza,
                TipoConta.SINTETICA,
                nivel,
                false
        );
    }

    public static PlanoConta criarAnalitica(
            String codigo,
            String descricao,
            NaturezaConta natureza,
            Integer nivel) {

        return criar(
                codigo,
                descricao,
                natureza,
                TipoConta.ANALITICA,
                nivel,
                true
        );
    }

    private static PlanoConta criar(
            String codigo,
            String descricao,
            NaturezaConta natureza,
            TipoConta tipoConta,
            Integer nivel,
            boolean aceitaLancamento) {

        int id = sequencia++;

        PlanoConta conta = new PlanoConta();

        conta.setId(id);
        conta.setCodigoInterno(id);
        conta.setCodigo(codigo);
        conta.setDescricao(descricao);
        conta.setNatureza(natureza);
        conta.setTipoConta(tipoConta);
        conta.setNivel(nivel);
        conta.setAceitaLancamento(aceitaLancamento);
        conta.setAtivo(true);

        return conta;
    }

    /**
     * Reinicia a sequência de IDs.
     * Útil para testes.
     */
    public static void reiniciarSequencia() {
        sequencia = 1;
    }
}