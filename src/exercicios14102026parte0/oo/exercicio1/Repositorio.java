package exercicios14102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class Repositorio<T, ID> {

	private final List<T> elementos = new ArrayList<>();
    private final Function<T, ID> identificador;

    public Repositorio(Function<T, ID> identificador) {
        this.identificador = identificador;
    }

    public void adicionar(T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("Elemento obrigatorio");
        }

        ID id = identificador.apply(elemento);

        if (buscar(id).isPresent()) {
            throw new IllegalArgumentException("Identificador duplicado");
        }

        elementos.add(elemento);
    }

    public Optional<T> buscar(ID id) {
        return elementos.stream()
                .filter(elemento ->
                        identificador.apply(elemento).equals(id))
                .findFirst();
    }

    public List<T> listar() {
        return List.copyOf(elementos);
    }

    public List<T> filtrar(Predicate<T> criterio) {
        return elementos.stream()
                .filter(criterio)
                .toList();
    }

    public int quantidade() {
        return elementos.size();
    }
    
}