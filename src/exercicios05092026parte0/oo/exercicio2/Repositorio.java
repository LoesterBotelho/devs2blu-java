package exercicios05092026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Repositorio<T extends Identificavel> {
    private List<T> elementos = new ArrayList<>();

    public void salvar(T elemento) {
        elementos.add(elemento);
    }

    public Optional<T> buscarPorId(int id) {
        return elementos.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    public List<T> listarTodos() {
        return new ArrayList<>(elementos);
    }
}
