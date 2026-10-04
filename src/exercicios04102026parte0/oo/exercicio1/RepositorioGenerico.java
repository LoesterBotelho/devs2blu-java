package exercicios04102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class RepositorioGenerico<T, ID>
        implements Repositorio<T, ID> {

    private List<T> dados = new ArrayList<>();

    private Function<T, ID> identificador;

    public RepositorioGenerico(Function<T, ID> identificador) {
        this.identificador = identificador;
    }

    @Override
    public void salvar(T objeto) {
        dados.add(objeto);
    }

    @Override
    public void remover(ID id) {

        dados.removeIf(
                objeto -> identificador.apply(objeto).equals(id)
        );
    }

    @Override
    public Optional<T> buscar(ID id) {

        return dados.stream()
                .filter(objeto ->
                        identificador.apply(objeto).equals(id))
                .findFirst();
    }

    @Override
    public List<T> listar() {
        return new ArrayList<>(dados);
    }

    public List<T> filtrar(Predicate<T> predicate) {

        return dados.stream()
                .filter(predicate)
                .toList();
    }
}