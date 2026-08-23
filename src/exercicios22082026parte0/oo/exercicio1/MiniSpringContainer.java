package exercicios22082026parte0.oo.exercicio1;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MiniSpringContainer {
    
	
    // Nosso container Singleton (Chave: Classe, Valor: A Instância única)
    private static final Map<Class<?>, Object> beanContainer = new HashMap<>();

    
    public static void iniciar(Class<?>... classes) throws Exception {
    	
        // 1. Instancia todos os componentes escaneados
        for (Class<?> clazz : classes) {
        	
            if (isBean(clazz)) {
            	
                // Cria a instância usando o construtor padrão e guarda no mapa (Singleton)
                Object instance = clazz.getDeclaredConstructor().newInstance();
                beanContainer.put(clazz, instance);
            }
            
        }
        
        

        // 2. Faz a Injeção de Dependências (@Autowired nas variáveis)
        for (Map.Entry<Class<?>, Object> entry : beanContainer.entrySet()) {
            Class<?> clazz = entry.getKey();
            Object instance = entry.getValue();

            for (Field field : clazz.getDeclaredFields()) {
               
            	
            	if (field.isAnnotationPresent(Autowired.class)) {
                    Class<?> dependencyType = field.getType();
                    
                    // Busca a dependência já criada no container
                    Object dependencyInstance = beanContainer.get(dependencyType);

                    if (dependencyInstance != null) {
                        field.setAccessible(true); // Permite injetar em campos private
                        field.set(instance, dependencyInstance); // Faz a injeção!
                    } else {
                        throw new RuntimeException("Dependência não encontrada para o tipo: " + dependencyType.getName());
                    }
                    
                    
                }
            	
            	
            	
            	
            	
            }
        }
    }

    
    
    // Helper para verificar se a classe possui alguma das nossas anotações de Bean
    private static boolean isBean(Class<?> clazz) {
        return clazz.isAnnotationPresent(Component.class) ||
               clazz.isAnnotationPresent(Service.class) ||
               clazz.isAnnotationPresent(Controller.class) ||
               clazz.isAnnotationPresent(RestController.class);
    }

    
    
    // Método para recuperar o bean pronto para uso
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clazz) {
        return (T) beanContainer.get(clazz);
    }
}