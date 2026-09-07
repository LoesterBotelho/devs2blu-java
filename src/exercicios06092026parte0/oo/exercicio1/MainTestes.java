package exercicios06092026parte0.oo.exercicio1;

public class MainTestes {
    public static void main(String[] args) {
    	
    	
        //---------------------------------------------------------------------------------------------------    	
    	
    	
        Repository<User, Long> userRepository = new InMemoryRepository<>();
        
        userRepository.save(new User(1L, "Loester Botelho", "loester@email.com"));
        userRepository.save(new User(2L, "Outra pessoa", "other@email.com"));


        var results = userRepository.findBy(u -> u.email().contains("loester"));
        
        results.forEach(user -> System.out.println("Encontrado: " + user.name()));

        //---------------------------------------------------------------------------------------------------
        
        

        Repository<Product, String> productRepository = new InMemoryRepository<>();
        
        productRepository.save(new Product("P-001", "Laptop", 15000.00));
        productRepository.save(new Product("P-002", "Computador Workstation", 50000.00));
        
        
        productRepository.findById("P-001").ifPresent(p -> 
            System.out.println("Produto Encontrado: " + p.title() + " | Preço: R$ " + p.price())
        );
        
        
        //---------------------------------------------------------------------------------------------------
        
        
    }
}