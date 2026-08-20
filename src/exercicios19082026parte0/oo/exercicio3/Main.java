package exercicios19082026parte0.oo.exercicio3;

public class Main {

    public static void main(String[] args) {

        Funcionario funcionario =
                new Funcionario(
                        "Carlos",
                        35,
                        "111.111.111-11",
                        "Analista",
                        5000,
                        "TI");

        Professor professor =
                new Professor(
                        "Maria",
                        40,
                        "222.222.222-22",
                        "Programacao",
                        "Mestre",
                        40);

        funcionario.exibirDados();

        professor.exibirDados();

        professor.realizarCompra();

        professor.consultarSaldo();
    }
}