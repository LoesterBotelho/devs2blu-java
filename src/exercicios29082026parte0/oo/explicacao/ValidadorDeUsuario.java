package exercicios29082026parte0.oo.explicacao;

import exercicios29082026parte0.oo.explicacao.errocustom.SenhaFracaException;

public class ValidadorDeUsuario {

	// 2. Método utilizando 'throws' para propagar a exceção
	public static void cadastrarSenha(String senha) throws SenhaFracaException {
		if (senha == null || senha.length() < 6) {
			
			// 3. Lançando manualmente a exceção com 'throw'
			throw new SenhaFracaException();
		}
		System.out.println("Senha cadastrada com sucesso!");
	}

	
	
	public static void main(String[] args) {
		
		// Teste alterando para uma senha maior (ex: "Abc1234")
		String tentativaSenha = "123"; 

		try {
			System.out.println("Tentando realizar o cadastro...");
			cadastrarSenha(tentativaSenha);

		} catch (SenhaFracaException e) {
			// Tratamento específico da exceção personalizada criada
			System.out.println( e.getMessage() );

		} finally {
			System.out.println("Processo de validação de senha encerrado.");
		}
	}
	
	
	
}