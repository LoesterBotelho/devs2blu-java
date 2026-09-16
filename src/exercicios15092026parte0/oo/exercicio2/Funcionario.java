package exercicios15092026parte0.oo.exercicio2;

public record Funcionario(
        Long id,
        String nome,
        Cargo cargo,
        Nivel nivel,
        double salario
) {
}