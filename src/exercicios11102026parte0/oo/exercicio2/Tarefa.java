package exercicios11102026parte0.oo.exercicio2;

public class Tarefa {

	private final int id;
    private final String descricao;
    private final Prioridade prioridade;
    private boolean concluida;

    public Tarefa(int id, String descricao, Prioridade prioridade) {
        this.id = id;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.concluida = false;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void concluir() {
        concluida = true;
    }

    @Override
    public String toString() {
        return id + " - " + descricao
                + " - " + prioridade
                + " - Concluida: " + concluida;
    }
    
}