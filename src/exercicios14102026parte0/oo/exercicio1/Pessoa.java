package exercicios14102026parte0.oo.exercicio1;

public abstract class Pessoa {
	
    private final String nome;
    private final String documento;
    private final int idade;

    protected Pessoa(String nome, String documento, int idade) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome obrigatorio");
        }
        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException("Documento obrigatorio");
        }
        if (idade < 0) {
            throw new IllegalArgumentException("Idade invalida");
        }

        this.nome = nome;
        this.documento = documento;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public int getIdade() {
        return idade;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return getTipo() + ": " + nome
                + " | Documento: " + documento
                + " | Idade: " + idade;
    }
    
}