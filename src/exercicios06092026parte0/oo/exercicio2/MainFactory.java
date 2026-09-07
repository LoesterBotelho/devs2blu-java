package exercicios06092026parte0.oo.exercicio2;

public class MainFactory {
    public static void main(String[] args) {
        
    	
    	var registry = new NotificationServiceRegistry();
        
    	
        registry.register(new EmailProcessor());
        registry.register(new SmsProcessor());

        
        Notification email = new EmailNotification("cliente@domain.com", "Sua fatura chegou.");
        Notification sms = new SmsNotification("+5547999999999", "Código de acesso: 1234");

        
        registry.dispatch(email);
        registry.dispatch(sms);
        
        
    }
}