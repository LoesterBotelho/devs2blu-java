public class OperadoresComparacao {

    public static void main(String[] args) {

        int x = 1;
        int y = 3;

        System.out.println("Valor inicial: " + x);
        // Pré-incremento
        System.out.println("Pré-incremento (++x):");
        System.out.println("Resultado da expressão: " + (++x));
        System.out.println("Valor da variável x: " + x);

        // Pós-incremento
        System.out.println("\nPós-incremento (x++):");
        System.out.println("Resultado da expressão: " + (x++));
        System.out.println("Valor da variável x: " + x);

        // Pré-decremento
        System.out.println("\nPré-decremento (--x):");
        System.out.println("Resultado da expressão: " + (--x));
        System.out.println("Valor da variável x: " + x);

        // Pós-decremento
        System.out.println("\nPós-decremento (x--):");
        System.out.println("Resultado da expressão: " + (x--));
        System.out.println("Valor da variável x: " + x);
        
        // Resto da divisão
        System.out.println("Resto da divisão (10 % 3): " + (10 % 3));

        // Comparações
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        boolean igual = (x == y);       
        boolean diferente = (x != y);
        boolean maior = (x > y);
        boolean menor = (x < y);
        boolean maiorOuIgual = (x >= y);
        boolean menorOuIgual = (x <= y);

        System.out.println("igual: " + igual);
        System.out.println("diferente: " + diferente);
        System.out.println("maior: " + maior);
        System.out.println("menor: " + menor);
        System.out.println("maiorOuIgual: " + maiorOuIgual);        
        System.out.println("menorOuIgual: " + menorOuIgual);
    }
}