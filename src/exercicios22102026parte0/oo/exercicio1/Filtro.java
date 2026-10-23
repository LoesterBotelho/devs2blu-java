package exercicios22102026parte0.oo.exercicio1;

@FunctionalInterface
public interface Filtro<T> {
    boolean testar(T objeto);
}