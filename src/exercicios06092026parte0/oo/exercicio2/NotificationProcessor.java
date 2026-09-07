package exercicios06092026parte0.oo.exercicio2;

interface NotificationProcessor<T extends Notification> {
    void process(T notification);
    Class<T> supportedType();
}