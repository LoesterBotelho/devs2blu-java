package exercicios21082026.exceptions;

public class ConexaoBanco implements AutoCloseable {

    public ConexaoBanco() {
        System.out.println("Conexão aberta.");
    }

    public void consultarDados() {
        System.out.println("Consultando dados no banco...");
        
        // Simulando uma falha técnica inesperada
        throw new RuntimeException("Falha crítica de comunicação com o servidor de banco de dados!");
    }

    @Override
    public void close() {
        System.out.println("Conexão fechada automaticamente.");
    }
}
