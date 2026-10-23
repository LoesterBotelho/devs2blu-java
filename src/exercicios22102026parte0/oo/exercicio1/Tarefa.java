package exercicios22102026parte0.oo.exercicio1;

public class Tarefa implements Identificavel {

    private final Long id;
    private String descricao;
    private Prioridade prioridade;
    private StatusTarefa status;
    private final Projeto projeto;

    public Tarefa(
            Long id,
            String descricao,
            Prioridade prioridade,
            StatusTarefa status,
            Projeto projeto) {
        this.id = id;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.projeto = projeto;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tarefa{id=%d, descricao='%s', prioridade=%s, status=%s}"
                .formatted(id, descricao, prioridade, status);
    }
}