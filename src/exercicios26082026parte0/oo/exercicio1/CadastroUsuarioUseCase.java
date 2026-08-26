package exercicios26082026parte0.oo.exercicio1;

public class CadastroUsuarioUseCase {
	
    // Inversão de dependência: depende da abstração
    private final UsuarioRepository usuarioRepository;

    // Injeção de dependência via construtor
    public CadastroUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void cadastrar(String nome, String email) {
        System.out.println("Validando dados do usuário: " + nome + " (" + email + ")");
        
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Erro: O nome do usuário não pode ser vazio.");
            return;
        }

        if (!email.contains("@")) {
            System.out.println("Erro: E-mail inválido.");
            return;
        }

        // Delega a persistência para o repositório injetado
        usuarioRepository.salvar(nome, email);
        System.out.println("Usuário cadastrado e persistido com sucesso!\n");
    }
    
}