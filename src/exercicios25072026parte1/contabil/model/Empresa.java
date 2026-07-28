package exercicios25072026parte1.contabil.model;

import java.io.Serializable;

import exercicios25072026parte1.contabil.interfaces.Identificavel;

public abstract class Empresa<ID extends Serializable>
        implements Identificavel<ID>, Serializable {

    private static final long serialVersionUID = 1L;

    private ID id;

    @Override
    public ID getId() {
        return id;
    }

    @Override
    public void setId(ID id) {
        this.id = id;
    }

}