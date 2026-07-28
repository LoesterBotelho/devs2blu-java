package exercicios25072026parte1.contabil.model;

import java.io.Serializable;
import java.util.Objects;

import exercicios25072026parte1.contabil.interfaces.Identificavel;


public abstract class Entidade<ID>
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



    @Override
    public boolean equals(Object obj) {


        if(this == obj) {

            return true;

        }



        if(!(obj instanceof Entidade<?> outra)) {

            return false;

        }



        if(id == null || outra.id == null) {

            return false;

        }



        return Objects.equals(
                id,
                outra.id
        );

    }



    @Override
    public int hashCode() {


        return id == null

                ? System.identityHashCode(this)

                : Objects.hash(id);

    }


}