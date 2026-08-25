package exercicios25082026parte0.oo.exercicio1;

public class EmailMensageiro implements Mensageiro {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("[EMAIL] Enviando para " + destinatario + ": " + mensagem);
    }
}
