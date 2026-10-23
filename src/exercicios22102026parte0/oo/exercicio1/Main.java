package exercicios22102026parte0.oo.exercicio1;

import java.util.Comparator;

class Main {

    void main() {
        Desenvolvedor desenvolvedor = new Desenvolvedor(
                1L, "Loester", "Java"
        );

        Projeto projeto = new Projeto(
                1L, "Sistema de Tarefas", desenvolvedor
        );

        RepositorioTarefas repositorio = new RepositorioTarefas();
        GerenciadorTarefas gerenciador =
                new GerenciadorTarefas(repositorio);

        gerenciador.adicionar(new Tarefa(
                1L, "Estudar Collections",
                Prioridade.ALTA, StatusTarefa.PENDENTE, projeto
        ));

        gerenciador.adicionar(new Tarefa(
                2L, "Praticar Generics",
                Prioridade.MEDIA, StatusTarefa.EM_ANDAMENTO, projeto
        ));

        gerenciador.adicionar(new Tarefa(
                3L, "Estudar Lambda",
                Prioridade.ALTA, StatusTarefa.CONCLUIDA, projeto
        ));

        System.out.println("TODAS AS TAREFAS");
        gerenciador.listarTodas().forEach(System.out::println);

        System.out.println("\nTAREFAS PENDENTES");
        gerenciador.filtrar(
                tarefa -> tarefa.getStatus() == StatusTarefa.PENDENTE
        ).forEach(System.out::println);

        System.out.println("\nTAREFAS POR PRIORIDADE");
        gerenciador.listarTodas().stream()
                .sorted(Comparator.comparing(Tarefa::getPrioridade))
                .forEach(System.out::println);

        System.out.println("\nESTATÍSTICAS");
        EstatisticasTarefas estatisticas =
                new EstatisticasTarefas(gerenciador.listarTodas());

        System.out.println("Total: " + estatisticas.total());
        System.out.println("Concluídas: " + estatisticas.concluidas());
        System.out.println("Pendentes: " + estatisticas.pendentes());

        System.out.println("\nBUSCA POR ID");
        gerenciador.buscarPorId(2L).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Tarefa não encontrada")
        );
    }
}