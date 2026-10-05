package exercicios05102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class GenericRepository<T, ID>
        implements Repository<T, ID> {

    private final List<T> dados = new ArrayList<>();

    private final Function<T, ID> identificador;

    public GenericRepository(
            Function<T, ID> identificador) {

        this.identificador = identificador;
    }

    @Override
    public void salvar(T objeto) {
        dados.add(objeto);
    }

    @Override
    public Optional<T> buscar(ID id) {

        return dados.stream()
                .filter(objeto ->
                        identificador
                                .apply(objeto)
                                .equals(id))
                .findFirst();
    }

    @Override
    public List<T> listar() {
        return List.copyOf(dados);
    }

    @Override
    public void remover(ID id) {

        dados.removeIf(objeto ->
                identificador
                        .apply(objeto)
                        .equals(id));
    }

    public List<T> filtrar(
            Predicate<T> predicate) {

        return dados.stream()
                .filter(predicate)
                .toList();
    }
}