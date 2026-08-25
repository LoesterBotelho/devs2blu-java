package exercicios25082026parte0.oo.exercicio1;

public class NotificacaoService {
    // Dependência injetada via interface (DIP)
    private final Mensageiro mensageiro;

    public NotificacaoService(Mensageiro mensageiro) {
        this.mensageiro = mensageiro;
    }

    public void dispararAlerta(String usuario, String alerta) {
        System.out.println("Preparando alerta crítico...");
        mensageiro.enviar(usuario, alerta);
    }
}