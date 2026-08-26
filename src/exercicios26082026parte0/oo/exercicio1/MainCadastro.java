package exercicios26082026parte0.oo.exercicio1;

public class MainCadastro {
    public static void main(String[] args) {

        System.out.println("--- MySQL ---");
        UsuarioRepository repoMySQL = new UsuarioRepositoryMySQL();
        CadastroUsuarioUseCase casoDeUsoMySQL = new CadastroUsuarioUseCase(repoMySQL);
        
        casoDeUsoMySQL.cadastrar("Carlos Silva", "carlos@email.com");


        System.out.println("--- MongoDB ---");
        UsuarioRepository repoMongo = new UsuarioRepositoryMongo();
        CadastroUsuarioUseCase casoDeUsoMongo = new CadastroUsuarioUseCase(repoMongo);
        
        casoDeUsoMongo.cadastrar("Ana Souza", "ana@email.com");
    }
}