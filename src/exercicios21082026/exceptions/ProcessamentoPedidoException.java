package exercicios21082026.exceptions;

public class ProcessamentoPedidoException extends Exception {
    private static final long serialVersionUID = -4435796251906232947L;

	public ProcessamentoPedidoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
