/**
 * Classe genérica que pode armazenar qualquer tipo de objeto.
 *
 * T = Type (Tipo)
 */
public class Caixa<T> {

    // Atributo genérico
    private T objeto;

    /**
     * Método para armazenar um objeto.
     */
    public void guardar(T objeto) {
        this.objeto = objeto;
    }

    /**
     * Método para retornar o objeto armazenado.
     */
    public T obter() {
        return objeto;
    }
}