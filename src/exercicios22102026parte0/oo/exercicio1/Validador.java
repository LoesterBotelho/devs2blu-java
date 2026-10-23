package exercicios22102026parte0.oo.exercicio1;

import java.util.function.Predicate;

public class Validador<T> {

    private final Predicate<T> regra;

    public Validador(Predicate<T> regra) {
        this.regra = regra;
    }

    public boolean validar(T objeto) {
        return regra.test(objeto);
    }
}