package exceptions.custom;

public class ServicoException extends Exception {

	private static final long serialVersionUID = -1251257734213139966L;

	public ServicoException(String mensagem) {
		super(mensagem);
	}

}