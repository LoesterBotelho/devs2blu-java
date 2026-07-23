package exemplos;

public class ExemploExceptions {

    public static void main(String[] args) {

        // 1. ArithmeticException
        try {
            int resultado = 10 / 0;
            System.out.println(resultado);
        } catch (ArithmeticException e) {
            System.out.println("Não é possível dividir por zero.");
        }

        // 2. ArrayIndexOutOfBoundsException
        try {
            int[] numeros = {1, 2, 3};
            System.out.println(numeros[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Posição do array não existe.");
        }

        // 3. NullPointerException
        try {
            String nome = null;
            System.out.println(nome.length());
        } catch (NullPointerException e) {
            System.out.println("Objeto está nulo.");
        }

        // 4. NumberFormatException
        try {
            String valor = "ABC";
            int numero = Integer.parseInt(valor);
            System.out.println(numero);
        } catch (NumberFormatException e) {
            System.out.println("Texto inválido para conversão.");
        }

        // 5. Multiple Catch
        try {
            String texto = null;
            int[] vetor = {10, 20};

            System.out.println(texto.length());
            System.out.println(vetor[5]);

        } catch (NullPointerException e) {
            System.out.println("Erro: objeto nulo.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: índice inválido.");
        }

        // 6. Finally
        try {
            int numero = 10 / 2;
            System.out.println("Resultado: " + numero);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro.");
        } finally {
            System.out.println("Finally sempre executa.");
        }

        // 7. Método com throws
        try {
            validarIdade(15);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // Lança exceção caso a idade seja menor que 18
    public static void validarIdade(int idade) throws Exception {

        if (idade < 18) {
            throw new Exception("Idade mínima é 18 anos.");
        }

        System.out.println("Acesso permitido.");
    }
}