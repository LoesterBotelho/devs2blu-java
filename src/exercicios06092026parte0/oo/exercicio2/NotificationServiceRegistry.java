package exercicios06092026parte0.oo.exercicio2;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class NotificationServiceRegistry {
	
    private final Map<Class<?>, NotificationProcessor<?>> registry = new HashMap<>();


    public <T extends Notification> void register(NotificationProcessor<T> processor) {
        registry.put(processor.supportedType(), processor);
    }


    @SuppressWarnings("unchecked")
    public <T extends Notification> void dispatch(T notification) {
        NotificationProcessor<T> processor = (NotificationProcessor<T>) registry.get(notification.getClass());
        
        Optional.ofNullable(processor)
                .orElseThrow(() -> new IllegalArgumentException("Processador não encontrado para: " + notification.getClass().getSimpleName()))
                .process(notification);
    }
        
}