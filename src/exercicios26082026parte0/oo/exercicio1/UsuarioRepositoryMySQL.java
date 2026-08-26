package exercicios26082026parte0.oo.exercicio1;

public class UsuarioRepositoryMySQL implements UsuarioRepository {
    @Override
    public void salvar(String nome, String email) {
        System.out.println("[MySQL] Conectando ao banco relacional...");
        System.out.println("[MySQL] INSERT INTO usuarios (nome, email) VALUES ('" + nome + "', '" + email + "');");
    }
}