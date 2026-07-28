package exercicios25072026parte1.contabil.interfaces;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Repository<T, ID> {


    void salvar(T entidade);


    void salvarTodos(List<T> entidades);


    void removerPorId(ID id);


    void remover(T entidade);


    void limpar();


    Optional<T> buscar(ID id);


    List<T> listar();


    List<T> listarOrdenado(Comparator<T> comparator);


    List<T> filtrar(Predicate<T> predicate);


    Optional<T> primeiro(Predicate<T> predicate);


    boolean existe(ID id);


    boolean existe(Predicate<T> predicate);


    long quantidade();


    void atualizar(ID id, Consumer<T> consumer);


    <R> List<R> map(Function<T, R> mapper);

}