package exercicios15092026parte0.oo.exercicio1;

public record Funcionario(
        Long id,
        String nome,
        double salarioBase
) implements Identifiable<Long> {

    @Override
    public Long getId() {
        return id;
    }

}