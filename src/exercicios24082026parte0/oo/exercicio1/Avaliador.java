package exercicios24082026parte0.oo.exercicio1;

public class Avaliador extends Pessoa {
	private String especialidade;

	public Avaliador(String nome, String email, String especialidade) {
		super(nome, email);
		this.especialidade = especialidade;
	}

	public String getEspecialidade() {
		return especialidade;
	}
}