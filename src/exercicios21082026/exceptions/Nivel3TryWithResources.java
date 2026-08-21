package exercicios21082026.exceptions;

public class Nivel3TryWithResources {
	
    public static void main(String[] args) {
    	
        try (ConexaoBanco conexao = new ConexaoBanco()) {
        	
            conexao.consultarDados();
            
        } catch (RuntimeException e) {
        	
            System.err.println("Exceção capturada no main: " + e.getMessage());
            
        }
    }
}
