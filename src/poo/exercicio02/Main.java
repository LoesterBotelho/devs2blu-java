package poo.exercicio02;

public class Main {

    public static void main(String[] args) {

        Universidade universidade = new Universidade("Universidade Java");

        universidade.mostrarNome();

        System.out.println();

        Pessoa[] pessoas = new Pessoa[6];

        pessoas[0] = new Aluno("João", 20, "Ciência da Computação");
        pessoas[1] = new Professor("Maria", 45, "Programação");
        pessoas[2] = new Funcionario("Carlos", 38, "Bibliotecário");
        pessoas[3] = new Aluno("Ana", 22, "Engenharia");
        pessoas[4] = new Professor("Pedro", 50, "Banco de Dados");
        pessoas[5] = new Funcionario("Fernanda", 31, "Secretária");

        for (Pessoa pessoa : pessoas) {

            pessoa.apresentar();

            if (pessoa instanceof Aluno) {
                ((Aluno) pessoa).estudar();
            }

            if (pessoa instanceof Professor) {
                ((Professor) pessoa).ensinar();
            }

            if (pessoa instanceof Funcionario) {
                ((Funcionario) pessoa).trabalhar();
            }

            System.out.println("-----------------------------");
        }
    }
}