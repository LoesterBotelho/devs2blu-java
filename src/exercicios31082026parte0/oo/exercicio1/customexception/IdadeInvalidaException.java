package exercicios31082026parte0.oo.exercicio1.customexception;

//Exceção personalizada herdando de Exception
public class IdadeInvalidaException extends Exception {
	private static final long serialVersionUID = 6267632184404303157L;

 public IdadeInvalidaException(String mensagem) {
     super(mensagem);
 }
}
