package exercicios13082026parte0.oo.heranca.exercicio03;

class Pai {

	String nome;
	String endereco;

	public Pai() {
		System.out.println("Construtor da classe Pai");
		this.nome = "Jose";
		this.endereco = "Rua Heinrich Hosang, 605, no bairro Victor Konder, em Blumenau, Santa Catarina";
	}

	public void mostrar() {
		System.out.println("Nome do Pai: " + this.nome);
		System.out.println("Endereço do Pai : " + this.endereco);
	}

}
