package exercicios22102026parte0.oo.exercicio1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EstatisticasTarefas {

    private final List<Tarefa> tarefas;

    public EstatisticasTarefas(List<Tarefa> tarefas) {
        this.tarefas = List.copyOf(tarefas);
    }

    public long total() {
        return tarefas.size();
    }

    public long concluidas() {
        return tarefas.stream()
                .filter(t -> t.getStatus() == StatusTarefa.CONCLUIDA)
                .count();
    }

    public long pendentes() {
        return tarefas.stream()
                .filter(t -> t.getStatus() == StatusTarefa.PENDENTE)
                .count();
    }

    public Map<StatusTarefa, Long> contarPorStatus() {
        return tarefas.stream().collect(
                Collectors.groupingBy(
                        Tarefa::getStatus,
                        Collectors.counting()
                )
        );
    }

    public Map<Prioridade, List<Tarefa>> agruparPorPrioridade() {
        return tarefas.stream().collect(
                Collectors.groupingBy(Tarefa::getPrioridade)
        );
    }

    public List<String> descricoes() {
        return tarefas.stream()
                .map(Tarefa::getDescricao)
                .toList();
    }
}