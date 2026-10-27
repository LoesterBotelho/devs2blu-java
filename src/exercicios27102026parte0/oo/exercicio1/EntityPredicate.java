package exercicios27102026parte0.oo.exercicio1;

@FunctionalInterface
public interface EntityPredicate<T> {

    boolean test(T entity);
    
}