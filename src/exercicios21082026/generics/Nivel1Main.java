package exercicios21082026.generics;

public class Nivel1Main {
    public static void main(String[] args) {
        // Caixa de String
        Caixa<String> caixaDeTexto = new Caixa<>();
        caixaDeTexto.guardar("Segredos de Java");
        String texto = caixaDeTexto.abrir(); // Sem cast necessário!

        // Caixa de Integer
        Caixa<Integer> caixaDeNumero = new Caixa<>();
        caixaDeNumero.guardar(42);
        int numero = caixaDeNumero.abrir();
    }
}