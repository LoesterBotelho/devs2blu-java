package exercicios06092026parte0.oo.exercicio2;

sealed interface Notification permits EmailNotification, SmsNotification, PushNotification {
    String destination();
    String message();
}
