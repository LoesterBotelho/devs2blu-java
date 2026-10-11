package exercicios11102026parte0.oo.exercicio2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GerenciadorTarefas {

	private final Map<Integer, Tarefa> tarefas = new HashMap<>();

    public void adicionar(Tarefa tarefa) {
        tarefas.put(tarefa.getId(), tarefa);
    }

    public Optional<Tarefa> buscar(int id) {
        return Optional.ofNullable(tarefas.get(id));
    }

    public boolean remover(int id) {
        return tarefas.remove(id) != null;
    }

    public List<Tarefa> listar() {
        return tarefas.values().stream()
                .sorted((a, b) -> Integer.compare(a.getId(), b.getId()))
                .toList();
    }

    public List<Tarefa> listarPorPrioridade(Prioridade prioridade) {
        return tarefas.values().stream()
                .filter(tarefa -> tarefa.getPrioridade() == prioridade)
                .toList();
    }

    public List<Tarefa> listarPendentes() {
        return tarefas.values().stream()
                .filter(tarefa -> !tarefa.isConcluida())
                .toList();
    }

    public int quantidade() {
        return tarefas.size();
    }
    
}