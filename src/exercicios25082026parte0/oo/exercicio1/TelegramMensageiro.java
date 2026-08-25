package exercicios25082026parte0.oo.exercicio1;

public class TelegramMensageiro implements Mensageiro {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("[TELEGRAM] Enviando mensagem para o chat " + destinatario + ": " + mensagem);
    }
}