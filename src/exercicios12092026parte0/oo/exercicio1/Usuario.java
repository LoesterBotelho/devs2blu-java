package exercicios12092026parte0.oo.exercicio1;

public record Usuario(Long id, String nome, String email) implements Identifiable<Long> {

    @Override
    public Long getId() {
        return id;
    }

}