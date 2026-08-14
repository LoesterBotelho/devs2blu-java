package exercicios13082026parte0.oo.heranca.exercicio02;

public class Main {
	public static void main(String[] args) {

		Pessoa p1 = new Cliente("Maria", 30, "C001");
		Pessoa p2 = new Professor("João", 40, 8000, "Java");
		Pessoa p3 = new Gerente("Carlos", 45, 12000);
		Pessoa p4 = new Desenvolvedor("Ana", 28, 7000, "Java");

		Pessoa[] pessoas = { p1, p2, p3, p4 };

		for (Pessoa pessoa : pessoas) {
			pessoa.apresentar();
		}
	}
}