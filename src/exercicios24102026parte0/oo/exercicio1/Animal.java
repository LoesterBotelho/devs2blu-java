package exercicios24102026parte0.oo.exercicio1;

import java.time.LocalDate;

public abstract class Animal implements Identificavel {
	
    private final Long id;
    private String nome;
    private final LocalDate nascimento;
    private final Tutor tutor;

    protected Animal(
            Long id,
            String nome,
            LocalDate nascimento,
            Tutor tutor) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }

        if (nascimento == null || nascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento inválida");
        }

        if (tutor == null) {
            throw new IllegalArgumentException("Tutor obrigatório");
        }

        this.id = id;
        this.nascimento = nascimento;
        this.tutor = tutor;
        setNome(nome);
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

    public LocalDate getNascimento() {
        return nascimento;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public int getIdade() {
        return (int) nascimento.until(LocalDate.now()).getYears();
    }

    public abstract Especie getEspecie();

    public abstract String emitirSom();
    
}