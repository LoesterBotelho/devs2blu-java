package exercicios22082026parte0.oo.exercicio1;

public class Main {

	
    public static void main(String[] args) throws Exception {
    	
        // Inicializa o nosso container passando as classes que devem ser gerenciadas
        MiniSpringContainer.iniciar(
            UsuarioService.class, 
            UsuarioController.class
        );

        
        // Recupera o controller do container (já com o service injetado automaticamente!)
        UsuarioController controller = MiniSpringContainer.getBean(UsuarioController.class);

        
        // Executa o método para testar
        controller.chamarServico(); 
        
        
    }
    
    
}