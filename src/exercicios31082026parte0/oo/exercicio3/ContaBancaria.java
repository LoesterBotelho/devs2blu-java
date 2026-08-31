package exercicios31082026parte0.oo.exercicio3;

public class ContaBancaria {

    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {

        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser maior que zero.");
        }

        saldo += valor;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {

        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser maior que zero.");
        }

        if (valor > saldo) {
            throw new SaldoInsuficienteException(
                    "Saldo insuficiente. Saldo atual: R$ " + saldo);
        }

        saldo -= valor;
    }

}