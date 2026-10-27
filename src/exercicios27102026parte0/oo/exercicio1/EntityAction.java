package exercicios27102026parte0.oo.exercicio1;

@FunctionalInterface
public interface EntityAction<T> {

    void execute(T entity);
    
}