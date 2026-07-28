package exercicios25072026parte1.contabil.model;

import java.io.Serializable;

import exercicios25072026parte1.contabil.interfaces.Identificavel;

public abstract class Entidade<ID> implements Identificavel<ID>, Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public abstract ID getId();

}