package exercicios22102026parte0.oo.exercicio1;

import java.util.List;
import java.util.Optional;

public class GerenciadorProjetos {

    private final Repositorio<Projeto> repositorio;

    public GerenciadorProjetos(Repositorio<Projeto> repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionar(Projeto projeto) {
        repositorio.adicionar(projeto);
    }

    public Optional<Projeto> buscarPorId(Long id) {
        return repositorio.buscarPorId(id);
    }

    public List<Projeto> listarTodos() {
        return repositorio.listarTodos();
    }

    public List<Projeto> filtrarPorNome(String trecho) {
        return listarTodos().stream()
                .filter(projeto -> projeto.getNome()
                        .toLowerCase()
                        .contains(trecho.toLowerCase()))
                .toList();
    }
}