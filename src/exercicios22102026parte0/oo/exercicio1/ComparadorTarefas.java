package exercicios22102026parte0.oo.exercicio1;

import java.util.Comparator;

public class ComparadorTarefas {

    public Comparator<Tarefa> porPrioridade() {
        return Comparator.comparing(Tarefa::getPrioridade);
    }

    public Comparator<Tarefa> porDescricao() {
        return Comparator.comparing(
                Tarefa::getDescricao,
                String.CASE_INSENSITIVE_ORDER
        );
    }

    public Comparator<Tarefa> porPrioridadeEDescricao() {
        return porPrioridade().thenComparing(porDescricao());
    }
}