package exercicios21082026.exceptions;

public class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Tentativa de saque acima do saldo disponível.", saldo);
        }
        saldo -= valor;
        System.out.println("Saque realizado com sucesso! Novo saldo: R$ " + saldo);
    }

    public double getSaldo() {
        return saldo;
    }
}
