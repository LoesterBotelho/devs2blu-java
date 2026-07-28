package exercicios25072026parte1.contabil.repository;

import java.io.Serializable;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import exercicios25072026parte1.contabil.interfaces.Identificavel;
import exercicios25072026parte1.contabil.interfaces.Repository;

public abstract class MemoryRepository<
        T extends Identificavel<ID>,
        ID extends Serializable>
        implements Repository<T, ID> {

    private final Map<ID, T> dados =
            new LinkedHashMap<>();

    /**
     * Gera um novo identificador para a entidade.
     */
    protected abstract ID gerarId();

    @Override
    public void salvar(T entidade) {

        Objects.requireNonNull(
                entidade,
                "Entidade obrigatória"
        );

        if (entidade.getId() == null) {
            entidade.setId(
                    gerarId()
            );
        }

        dados.put(
                entidade.getId(),
                entidade
        );

    }

    @Override
    public void salvarTodos(List<T> entidades) {

        Objects.requireNonNull(
                entidades,
                "Lista obrigatória"
        );

        entidades.forEach(this::salvar);

    }

    @Override
    public void removerPorId(ID id) {

        if (id != null) {
            dados.remove(id);
        }

    }

    @Override
    public void remover(T entidade) {

        if (entidade != null) {
            removerPorId(entidade.getId());
        }

    }

    @Override
    public void limpar() {

        dados.clear();

    }

    @Override
    public Optional<T> buscar(ID id) {

        return Optional.ofNullable(
                dados.get(id)
        );

    }

    @Override
    public List<T> listar() {

        return List.copyOf(
                dados.values()
        );

    }

    @Override
    public List<T> listarOrdenado(
            Comparator<T> comparator) {

        return dados.values()
                .stream()
                .sorted(
                        comparator != null
                                ? comparator
                                : Comparator.comparing(
                                        Object::hashCode
                                )
                )
                .toList();

    }

    @Override
    public List<T> filtrar(
            Predicate<T> predicate) {

        Objects.requireNonNull(
                predicate,
                "Predicate obrigatório"
        );

        return dados.values()
                .stream()
                .filter(predicate)
                .toList();

    }

    @Override
    public Optional<T> primeiro(
            Predicate<T> predicate) {

        Objects.requireNonNull(
                predicate,
                "Predicate obrigatório"
        );

        return dados.values()
                .stream()
                .filter(predicate)
                .findFirst();

    }

    @Override
    public boolean existe(ID id) {

        return dados.containsKey(id);

    }

    @Override
    public boolean existe(
            Predicate<T> predicate) {

        Objects.requireNonNull(
                predicate,
                "Predicate obrigatório"
        );

        return dados.values()
                .stream()
                .anyMatch(predicate);

    }

    @Override
    public long quantidade() {

        return dados.size();

    }

    @Override
    public void atualizar(
            ID id,
            Consumer<T> consumer) {

        Objects.requireNonNull(
                consumer,
                "Consumer obrigatório"
        );

        buscar(id)
                .ifPresent(consumer);

    }

    @Override
    public <R> List<R> map(
            Function<T, R> mapper) {

        Objects.requireNonNull(
                mapper,
                "Mapper obrigatório"
        );

        return dados.values()
                .stream()
                .map(mapper)
                .toList();

    }

}