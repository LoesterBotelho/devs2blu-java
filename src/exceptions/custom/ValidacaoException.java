package exceptions.custom;

public class ValidacaoException extends Exception {

	private static final long serialVersionUID = -5173779597624231747L;

	public ValidacaoException(String mensagem) {
		super(mensagem);
	}

}