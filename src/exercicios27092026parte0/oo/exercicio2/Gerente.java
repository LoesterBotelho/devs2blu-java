package exercicios27092026parte0.oo.exercicio2;

import java.math.BigDecimal;

public class Gerente extends Funcionario {

    private final BigDecimal salario;

    public Gerente(
            String nome,
            String cargo,
            BigDecimal salario) {

        super(nome, cargo);
        this.salario = salario;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return String.format(
                "Gerente{nome='%s', cargo='%s', salario=R$ %.2f}",
                getNome(),
                getCargo(),
                salario
        );
    }
}