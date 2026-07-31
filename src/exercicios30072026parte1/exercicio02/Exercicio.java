package exercicios30072026parte1.exercicio02;

public class Exercicio {

	private String pergunta;
	private String resposta;

	Exercicio() {
	}

	public Exercicio(String pergunta, String resposta) {
		this.pergunta = pergunta;
		this.resposta = resposta;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	@Override
	public String toString() {
		return "Exercicio [pergunta=" + pergunta + ", resposta=" + resposta + "]";
	}

}
