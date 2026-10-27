package exercicios27102026parte0.oo.exercicio1;

@FunctionalInterface
public interface EntityMapper<T, R> {
    
	R map(T entity);
    
}