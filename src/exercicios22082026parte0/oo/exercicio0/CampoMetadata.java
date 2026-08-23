package exercicios22082026parte0.oo.exercicio0;

import java.lang.reflect.Field;

public final class CampoMetadata {

    private final Field field;
    private final Campo campo;
    private final boolean id;

    public CampoMetadata(
        Field field,
        Campo campo,
        boolean id
    ) {
        this.field = field;
        this.campo = campo;
        this.id = id;
    }

    public Field field() {
        return field;
    }

    public Campo campo() {
        return campo;
    }

    public boolean id() {
        return id;
    }

    public String nome() {
        return campo.nome();
    }

    public boolean nullable() {
        return campo.nullable();
    }
}