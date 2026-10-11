package exercicios10102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Repositorio<T> {
	
    private final List<T> elementos = new ArrayList<>();

    public void adicionar(T elemento) {
        elementos.add(elemento);
    }

    public List<T> listar() {
        return List.copyOf(elementos);
    }

    public List<T> filtrar(Predicate<T> criterio) {
        return elementos.stream()
                .filter(criterio)
                .toList();
    }

    public Optional<T> primeiro() {
        return elementos.stream().findFirst();
    }

    public int tamanho() {
        return elementos.size();
    }
    
}