package exercicios25072026parte1.contabil.interfaces;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;



public interface Repository<T, ID> {



    /**
     * Salva ou atualiza uma entidade
     */
    void salvar(
            T entidade
    );




    /**
     * Salva várias entidades
     */
    void salvarTodos(
            List<T> entidades
    );




    /**
     * Remove pelo identificador
     */
    void removerPorId(
            ID id
    );




    /**
     * Remove pela própria entidade
     */
    void remover(
            T entidade
    );




    /**
     * Remove todos os registros
     */
    void limpar();




    /**
     * Busca por ID
     */
    Optional<T> buscar(
            ID id
    );




    /**
     * Lista todos
     */
    List<T> listar();




    /**
     * Lista ordenado
     */
    List<T> listarOrdenado(
            Comparator<T> comparator
    );




    /**
     * Filtra entidades
     */
    List<T> filtrar(
            Predicate<T> predicate
    );




    /**
     * Primeiro elemento encontrado
     */
    Optional<T> primeiro(
            Predicate<T> predicate
    );




    /**
     * Verifica existência por ID
     */
    boolean existe(
            ID id
    );




    /**
     * Verifica existência por condição
     */
    boolean existe(
            Predicate<T> predicate
    );




    /**
     * Quantidade de registros
     */
    long quantidade();




    /**
     * Atualização parcial
     */
    void atualizar(
            ID id,
            Consumer<T> consumer
    );




    /**
     * Transformação usando Stream
     */
    <R> List<R> map(
            Function<T,R> mapper
    );


}