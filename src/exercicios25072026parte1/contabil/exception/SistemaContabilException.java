package exercicios25072026parte1.contabil.exception;

public class SistemaContabilException extends RuntimeException {

	private static final long serialVersionUID = -4000828177923748169L;

	public SistemaContabilException(String mensagem) {
        super(mensagem);
    }

}