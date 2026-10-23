package exercicios22102026parte0.oo.exercicio1;

public class NotificadorConsole implements Notificador {

    @Override
    public void notificar(String mensagem) {
        System.out.println("[NOTIFICAÇÃO] " + mensagem);
    }
}