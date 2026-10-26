package exercicios25102026parte0.oo.exercicio1;

public abstract class Pessoa implements Identificavel {
	
    private final String id;
    private String nome;
    private String telefone;

    protected Pessoa(String id, String nome, String telefone) {
        if (id == null || id.isBlank() || nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("ID e nome são obrigatórios");
        }

        this.id = id;
        this.nome = nome;
        this.telefone = telefone == null ? "" : telefone;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome obrigatório");
        }

        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone == null ? "" : telefone;
    }
    
}