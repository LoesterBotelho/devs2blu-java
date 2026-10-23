package exercicios22102026parte0.oo.exercicio1;

import java.util.List;
import java.util.Optional;

public class GerenciadorTarefas {

    private final Repositorio<Tarefa> repositorio;

    public GerenciadorTarefas(Repositorio<Tarefa> repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionar(Tarefa tarefa) {
        repositorio.adicionar(tarefa);
    }

    public List<Tarefa> listarTodas() {
        return repositorio.listarTodos();
    }

    public Optional<Tarefa> buscarPorId(Long id) {
        return repositorio.buscarPorId(id);
    }

    public boolean remover(Long id) {
        return repositorio.remover(id);
    }

    public List<Tarefa> filtrar(Filtro<Tarefa> filtro) {
        return repositorio.listarTodos()
                .stream()
                .filter(filtro::testar)
                .toList();
    }

    public List<Tarefa> listarConcluidas() {
        return filtrar(
                tarefa -> tarefa.getStatus() == StatusTarefa.CONCLUIDA
        );
    }

    public List<Tarefa> listarPorPrioridade(Prioridade prioridade) {
        return filtrar(
                tarefa -> tarefa.getPrioridade() == prioridade
        );
    }
}