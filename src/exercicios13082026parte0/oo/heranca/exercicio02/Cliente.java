package exercicios13082026parte0.oo.heranca.exercicio02;

public class Cliente extends Pessoa {

	private String codigoCliente;

	public Cliente(String nome, int idade, String codigoCliente) {
		super(nome, idade);
		this.codigoCliente = codigoCliente;
	}

	@Override
	public void apresentar() {
		System.out.println("Sou o cliente " + getNome());
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

}