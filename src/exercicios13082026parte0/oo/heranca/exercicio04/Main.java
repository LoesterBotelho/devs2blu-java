package exercicios13082026parte0.oo.heranca.exercicio04;

public class Main {

	public static void main(String[] args) {

		Pessoa pessoa = new Pessoa("João", 30, "111.111.111-11", "Brasileiro");

		pessoa.apresentar();

		System.out.println("----------------");

		Funcionario funcionario = new Funcionario("Maria", 28, "222.222.222-22", "Brasileira", 6500);

		funcionario.apresentar();

		System.out.println("----------------");

		Gerente gerente = new Gerente("Carlos", 40, "333.333.333-33", "Brasileiro", 15000, "Tecnologia");

		gerente.apresentar();
	}
}