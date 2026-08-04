package exercicios30072026parte1.oo.desafio;

public enum ResultadoPartida {

	EM_ANDAMENTO("Em andamento"),
	VITORIA("Vitória"),
	EMPATE("Ninguém ganhou essa partida.");

	private final String mensagem;

	ResultadoPartida(String mensagem) {

		this.mensagem = mensagem;

	}

	public String getMensagem() {

		return mensagem;

	}

}