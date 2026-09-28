package exercicios27092026parte0.oo.exercicio2;

public class Funcionario extends Pessoa {

    private final String cargo;

    public Funcionario(
            String nome,
            String cargo) {

        super(nome);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return String.format(
                "Funcionario{nome='%s', cargo='%s'}",
                getNome(),
                cargo
        );
    }
}