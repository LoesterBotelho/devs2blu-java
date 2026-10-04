package exercicios04102026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class GenericRepository<T, ID> implements Repository<T, ID> {

    private final List<T> dados;
    private final Function<T, ID> idFunction;

    public GenericRepository(Function<T, ID> idFunction) {
        this.dados = new ArrayList<>();
        this.idFunction = idFunction;
    }

    @Override
    public void salvar(T objeto) {
        dados.add(objeto);
    }

    @Override
    public Optional<T> buscar(ID id) {
        return dados.stream()
                .filter(objeto -> idFunction.apply(objeto).equals(id))
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