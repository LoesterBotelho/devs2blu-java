package exercicios06092026parte0.oo.exercicio2;

class SmsProcessor implements NotificationProcessor<SmsNotification> {
	
	@Override
	public void process(SmsNotification n) {
		System.out.println("Enviando SMS para " + n.destination() + ": " + n.message());
	}

	@Override
	public Class<SmsNotification> supportedType() {
		return SmsNotification.class;
	}
	
}