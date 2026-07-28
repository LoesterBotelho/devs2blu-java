package exercicios25072026parte1.contabil.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import exercicios25072026parte1.contabil.interfaces.Identificavel;
import exercicios25072026parte1.contabil.interfaces.Repository;


public abstract class MemoryRepository<T extends Identificavel<ID>, ID>
        implements Repository<T, ID> {


    private final List<T> lista =
            new ArrayList<>();


    private final Map<ID,T> mapa =
            new LinkedHashMap<>();


    private final Map<ID,T> mapaOrdenado =
            new TreeMap<>();



    protected abstract ID gerarId();





    @Override
    public void salvar(T entidade) {


        Objects.requireNonNull(
                entidade,
                "Entidade obrigatória"
        );


        if(entidade.getId() == null) {

            entidade.setId(
                    gerarId()
            );

        }



        removerPorId(
                entidade.getId()
        );



        lista.add(entidade);


        mapa.put(
                entidade.getId(),
                entidade
        );


        mapaOrdenado.put(
                entidade.getId(),
                entidade
        );

    }







    @Override
    public void salvarTodos(
            List<T> entidades) {


        Objects.requireNonNull(
                entidades,
                "Lista obrigatória"
        );


        entidades.forEach(
                this::salvar
        );

    }








    @Override
    public void removerPorId(
            ID id) {


        if(id == null) {

            return;

        }



        lista.removeIf(

                item -> Objects.equals(
                        item.getId(),
                        id
                )

        );


        mapa.remove(id);


        mapaOrdenado.remove(id);

    }








    @Override
    public void remover(T entidade) {


        if(entidade == null) {

            return;

        }


        removerPorId(
                entidade.getId()
        );

    }








    @Override
    public Optional<T> buscar(ID id) {


        return Optional.ofNullable(
                mapa.get(id)
        );

    }








    @Override
    public List<T> listar() {


        return List.copyOf(
                lista
        );

    }








    @Override
    public List<T> listarOrdenado(
            Comparator<T> comparator) {


        return lista.stream()

                .sorted(comparator)

                .toList();

    }








    @Override
    public List<T> filtrar(
            Predicate<T> predicate) {


        return lista.stream()

                .filter(predicate)

                .toList();

    }








    @Override
    public Optional<T> primeiro(
            Predicate<T> predicate) {


        return lista.stream()

                .filter(predicate)

                .findFirst();

    }








    @Override
    public boolean existe(ID id) {


        return mapa.containsKey(id);

    }








    @Override
    public boolean existe(
            Predicate<T> predicate) {


        return lista.stream()

                .anyMatch(predicate);

    }








    @Override
    public long quantidade() {


        return lista.size();

    }








    @Override
    public void atualizar(
            ID id,
            Consumer<T> consumer) {


        buscar(id)

                .ifPresent(consumer);

    }








    @Override
    public <R> List<R> map(
            Function<T,R> mapper) {


        return lista.stream()

                .map(mapper)

                .toList();

    }








    @Override
    public void limpar() {


        lista.clear();


        mapa.clear();


        mapaOrdenado.clear();

    }


}