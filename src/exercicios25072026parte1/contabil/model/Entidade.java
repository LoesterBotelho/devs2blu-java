package exercicios25072026parte1.contabil.model;

import java.io.Serializable;
import java.util.Objects;

import exercicios25072026parte1.contabil.interfaces.Identificavel;

public abstract class Entidade<ID extends Serializable>
        implements Identificavel<ID>, Serializable {

    private static final long serialVersionUID = 1L;

    private ID id;

    protected Entidade() {
    }

    protected Entidade(ID id) {
        this.id = id;
    }

    @Override
    public ID getId() {
        return id;
    }

    @Override
    public void setId(ID id) {
        this.id = id;
    }

    public boolean isNova() {
        return id == null;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Entidade<?> outra = (Entidade<?>) obj;

        return Objects.equals(id, outra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}