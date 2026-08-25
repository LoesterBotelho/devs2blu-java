package exercicios25082026parte0.oo.exercicio1;

public class MainNotificacao {
    public static void main(String[] args) {
        // Injetando a implementação de E-mail
        Mensageiro emailService = new EmailMensageiro();
        NotificacaoService servicoEmail = new NotificacaoService(emailService);
        servicoEmail.dispararAlerta("joao@email.com", "Servidor fora do ar!");

        System.out.println("--------------------------------------------------");

        // Injetando a implementação de Telegram sem alterar o NotificacaoService
        Mensageiro telegramService = new TelegramMensageiro();
        NotificacaoService servicoTelegram = new NotificacaoService(telegramService);
        servicoTelegram.dispararAlerta("@joaodev", "Sua build foi concluída com sucesso!");
    }
}