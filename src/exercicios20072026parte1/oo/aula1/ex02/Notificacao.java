package exercicios20072026parte1.oo.aula1.ex02;

public final class Notificacao {

    private Notificacao() {
    }

    public static void enviar(Pagamento pagamento) {

        System.out.println();
        System.out.println("Pagamento realizado.");
        System.out.println();

        System.out.println("Comprovante:");
        System.out.println();

        System.out.println(pagamento.gerarComprovante());

        System.out.println("Obrigado pela compra!");
        System.out.println();

    }

}