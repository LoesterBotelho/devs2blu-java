package exercicios22102026parte0.oo.exercicio1;

public class Resultado<T> {

    private final boolean sucesso;
    private final String mensagem;
    private final T valor;

    public Resultado(boolean sucesso, String mensagem, T valor) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.valor = valor;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public T getValor() {
        return valor;
    }

    public static <T> Resultado<T> sucesso(T valor) {
        return new Resultado<>(true, "Operação realizada", valor);
    }

    public static <T> Resultado<T> erro(String mensagem) {
        return new Resultado<>(false, mensagem, null);
    }
}