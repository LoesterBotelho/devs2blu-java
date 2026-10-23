package exercicios22102026parte0.oo.exercicio1;

import java.util.List;

public class DadosExemplo {

    public static List<Tarefa> criarTarefas(Projeto projeto) {
        return List.of(
                new Tarefa(
                        1L, "Estudar Collections",
                        Prioridade.ALTA, StatusTarefa.PENDENTE, projeto
                ),
                new Tarefa(
                        2L, "Praticar Generics",
                        Prioridade.MEDIA,
                        StatusTarefa.EM_ANDAMENTO, projeto
                ),
                new Tarefa(
                        3L, "Estudar Lambda",
                        Prioridade.URGENTE, StatusTarefa.CONCLUIDA, projeto
                ),
                new Tarefa(
                        4L, "Praticar Stream API",
                        Prioridade.ALTA, StatusTarefa.PENDENTE, projeto
                )
        );
    }
}