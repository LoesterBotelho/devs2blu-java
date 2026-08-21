package exercicios21082026.exceptions;

public class SaldoInsuficienteException extends Exception {
    private static final long serialVersionUID = -2392497723927753800L;
	private final double saldoAtual;

    public SaldoInsuficienteException(String mensagem, double saldoAtual) {
        super(mensagem);
        this.saldoAtual = saldoAtual;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }
}
