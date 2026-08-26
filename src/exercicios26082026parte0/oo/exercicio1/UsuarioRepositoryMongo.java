package exercicios26082026parte0.oo.exercicio1;

public class UsuarioRepositoryMongo implements UsuarioRepository {
    @Override
    public void salvar(String nome, String email) {
        System.out.println("[MongoDB] Conectando ao cluster NoSQL...");
        System.out.println("[MongoDB] db.usuarios.insertOne({ nome: '" + nome + "', email: '" + email + "' });");
    }
}