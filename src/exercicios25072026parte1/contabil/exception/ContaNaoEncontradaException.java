package exercicios25072026parte1.contabil.exception;

public class ContaNaoEncontradaException extends SistemaContabilException {

	private static final long serialVersionUID = -3940060687382139295L;

	public ContaNaoEncontradaException(Integer codigo) {
        super("Conta " + codigo + " não encontrada.");
    }

}