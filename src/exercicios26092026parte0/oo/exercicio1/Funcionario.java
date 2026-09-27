package exercicios26092026parte0.oo.exercicio1;

import java.math.BigDecimal;

public class Funcionario {

    private final String id;
    private final String nome;
    private final BigDecimal salario;

    public Funcionario(String id, String nome, BigDecimal salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return String.format(
                "Funcionario{id='%s', nome='%s', salario=R$ %.2f}",
                id,
                nome,
                salario
        );
    }
}