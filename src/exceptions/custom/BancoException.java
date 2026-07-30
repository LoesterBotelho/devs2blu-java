package exceptions.custom;

public class BancoException extends Exception {

	private static final long serialVersionUID = -1700466332638668368L;

	public BancoException(String mensagem) {
		super(mensagem);
	}

}