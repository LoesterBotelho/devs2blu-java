package exercicios27082026parte0.oo.exercicio1;

public interface GatewayPagamento {
    boolean processarPagamento(double valor, String tokenCartaoOuChave);
}
