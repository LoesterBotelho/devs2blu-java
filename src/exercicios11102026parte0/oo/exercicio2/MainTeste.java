package exercicios11102026parte0.oo.exercicio2;

public class MainTeste {

    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();

        gerenciador.adicionar(new Tarefa(
                1, "Estudar Java 25", Prioridade.ALTA));

        gerenciador.adicionar(new Tarefa(
                2, "Praticar ingles", Prioridade.MEDIA));

        gerenciador.adicionar(new Tarefa(
                3, "Organizar arquivos", Prioridade.BAIXA));

        gerenciador.adicionar(new Tarefa(
                4, "Resolver exercicios", Prioridade.ALTA));

        gerenciador.buscar(1).ifPresent(Tarefa::concluir);

        System.out.println("TODAS AS TAREFAS");
        gerenciador.listar().forEach(System.out::println);

        System.out.println("\nPRIORIDADE ALTA");
        gerenciador.listarPorPrioridade(Prioridade.ALTA)
                .forEach(System.out::println);

        System.out.println("\nTAREFAS PENDENTES");
        gerenciador.listarPendentes()
                .forEach(System.out::println);

        System.out.println("\nBUSCAR TAREFA");
        gerenciador.buscar(2).ifPresent(System.out::println);

        System.out.println("\nREMOVER TAREFA");
        System.out.println(gerenciador.remover(3));

        System.out.println("\nQuantidade: " + gerenciador.quantidade());
    }
}