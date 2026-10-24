package exercicios24102026parte0.oo.exercicio1;

public abstract class Pessoa implements Identificavel {
	
    private final Long id;
    private String nome;
    private String telefone;

    protected Pessoa(Long id, String nome, String telefone) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }

        this.id = id;
        setNome(nome);
        setTelefone(telefone);
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome obrigatório");
        }

        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("Telefone obrigatório");
        }

        this.telefone = telefone;
    }
    
}