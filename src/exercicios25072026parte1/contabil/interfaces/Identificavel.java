package exercicios25072026parte1.contabil.interfaces;

import java.io.Serializable;

/**
 * Contrato para entidades que possuem identificador.
 *
 * @param <ID> Tipo do identificador.
 */
public interface Identificavel<ID extends Serializable> {

    /**
     * Retorna o identificador da entidade.
     *
     * @return identificador
     */
    ID getId();

    /**
     * Define o identificador da entidade.
     *
     * @param id identificador
     */
    void setId(ID id);

}