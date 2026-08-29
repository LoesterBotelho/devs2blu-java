package exercicios29082026parte0.oo.explicacao.errocustom;

public class SenhaFracaException extends Exception {

	private static final long serialVersionUID = 259860354823171927L;

	@Override
    public String getMessage() {
        return "Erro de Segurança: A senha deve conter pelo menos 6 caracteres.";
    }
}