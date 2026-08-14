package exercicios13082026parte0.oo.heranca.exercicio03;

class Filha extends Pai {

	String nomeFilha;
	private double salario;
	String telefone;

	public Filha() {
		System.out.println("Construtor da classe Filha");
		this.nomeFilha = "Sofia";
		this.salario = 15000.00;
		this.telefone = "(47) 99123-4567";
	}

	public void mostrarInfo() {
		super.mostrar();
		System.out.println("Nome da filha : " + this.nomeFilha);
		System.out.println("Salário da filha : " + this.salario);
		System.out.println("Telefone da filha : " + this.telefone);
	}
}
