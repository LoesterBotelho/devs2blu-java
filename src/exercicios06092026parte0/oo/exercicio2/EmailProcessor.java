package exercicios06092026parte0.oo.exercicio2;

class EmailProcessor implements NotificationProcessor<EmailNotification> {

	@Override
	public void process(EmailNotification n) {
		System.out.println("Enviando EMAIL para " + n.destination() + ": " + n.message());
	}

	@Override
	public Class<EmailNotification> supportedType() {
		return EmailNotification.class;
	}

}