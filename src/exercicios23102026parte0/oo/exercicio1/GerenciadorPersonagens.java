package exercicios23102026parte0.oo.exercicio1;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class GerenciadorPersonagens {

    private final Repositorio<Personagem> repositorio;

    public GerenciadorPersonagens(
            Repositorio<Personagem> repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionar(Personagem personagem) {
        repositorio.adicionar(personagem);
    }

    public Optional<Personagem> buscarPorId(Long id) {
        return repositorio.buscarPorId(id);
    }

    public List<Personagem> listarTodos() {
        return repositorio.listarTodos();
    }

    public List<Personagem> filtrar(
            Predicate<Personagem> criterio) {
        return listarTodos().stream()
                .filter(criterio)
                .toList();
    }

    public boolean remover(Long id) {
        return repositorio.remover(id);
    }
}