package exercicios25072026parte1.contabil.enums;


/**
 * Representa o ciclo de vida de um lançamento contábil.
 *
 * Fluxo esperado:
 *
 * RASCUNHO
 *      |
 *      v
 * VALIDADO
 *      |
 *      v
 * POSTADO
 *      |
 *      v
 * CANCELADO
 *
 */
public enum StatusLancamento {


    /**
     * Lançamento criado,
     * ainda não validado.
     */
    RASCUNHO,


    /**
     * Lançamento validado
     * e apto para postagem.
     */
    VALIDADO,


    /**
     * Lançamento efetivado na contabilidade.
     * Já influencia saldos e relatórios.
     */
    POSTADO,


    /**
     * Lançamento cancelado.
     * Deve possuir motivo e data de cancelamento.
     */
    CANCELADO;



    /**
     * Verifica se o lançamento pode receber alteração.
     */
    public boolean permiteAlteracao() {


        return this != POSTADO
                &&
                this != CANCELADO;

    }





    /**
     * Verifica se o lançamento está ativo
     * nos relatórios contábeis.
     */
    public boolean consideraMovimento() {


        return this == POSTADO;

    }





    /**
     * Verifica se o lançamento está encerrado.
     */
    public boolean encerrado() {


        return this == CANCELADO;

    }





    /**
     * Retorna descrição amigável.
     */
    public String descricao() {


        return switch (this) {


            case RASCUNHO ->
                    "Rascunho";


            case VALIDADO ->
                    "Validado";


            case POSTADO ->
                    "Postado";


            case CANCELADO ->
                    "Cancelado";


        };

    }





    @Override
    public String toString() {


        return descricao();

    }


}