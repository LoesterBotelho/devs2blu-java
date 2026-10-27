package exercicios26102026parte0.oo.exercicio1;

public record Room(long id, String name) {
	
    public Room {
    
    	if (id <= 0) {
            throw new IllegalArgumentException("Invalid room ID");
        }
    	
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Room name is required");
        }
        
    }
    
}