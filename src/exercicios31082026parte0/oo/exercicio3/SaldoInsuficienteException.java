package exercicios31082026parte0.oo.exercicio3;

public class SaldoInsuficienteException extends Exception {
	private static final long serialVersionUID = -1025857908709944868L;

	public SaldoInsuficienteException() {
        super();
    }

    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }

}