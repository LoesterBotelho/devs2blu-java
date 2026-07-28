package exercicios25072026parte1.contabil.exception;

public class LancamentoInvalidoException extends SistemaContabilException {

	private static final long serialVersionUID = 499240208780461142L;

	public LancamentoInvalidoException(String mensagem) {
        super(mensagem);
    }

}