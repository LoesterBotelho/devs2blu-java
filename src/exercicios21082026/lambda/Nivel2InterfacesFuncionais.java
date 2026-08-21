package exercicios21082026.lambda;

public class Nivel2InterfacesFuncionais {
    public static void main(String[] args) {
        // Usando a lambda para somar
        OperacaoMatematica soma = (a, b) -> a + b;
        
        // Usando a lambda para multiplicar
        OperacaoMatematica multiplicacao = (a, b) -> {
            System.out.println("Executando multiplicação...");
            return a * b;
        };

        System.out.println("Soma: " + soma.calcular(5, 3));           // Saída: 8
        System.out.println("Multiplicação: " + multiplicacao.calcular(4, 2)); // Saída: 8
    }
}