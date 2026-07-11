package exemplos;
/**
 * Classe demonstrando o uso do Operador Ternário em Java.
 *
 * O operador ternário é uma forma resumida de escrever
 * uma estrutura if/else.
 *
 * Sintaxe:
 * condição ? valorSeVerdadeiro : valorSeFalso;
 */
public class ExemploOperadorTernario {

    public static void main(String[] args) {

        // Exemplo 1 - Verificar maioridade
        int idade = 20;

        String status = idade >= 18
                ? "Maior de idade"
                : "Menor de idade";

        System.out.println("Idade: " + idade);
        System.out.println("Status: " + status);

        System.out.println("--------------------------------");

        // Exemplo 2 - Encontrar o maior número
        int numero1 = 25;
        int numero2 = 10;

        int maior = numero1 > numero2
                ? numero1
                : numero2;

        System.out.println("Número 1: " + numero1);
        System.out.println("Número 2: " + numero2);
        System.out.println("Maior número: " + maior);

        System.out.println("--------------------------------");

        // Exemplo 3 - Verificar se o número é par ou ímpar
        int numero = 15;

        String resultado = (numero % 2 == 0)
                ? "Par"
                : "Ímpar";

        System.out.println("Número: " + numero);
        System.out.println("Resultado: " + resultado);

        System.out.println("--------------------------------");

        // Exemplo 4 - Aprovação de aluno
        double nota = 8.5;

        String situacao = nota >= 7.0
                ? "Aprovado"
                : "Reprovado";

        System.out.println("Nota: " + nota);
        System.out.println("Situação: " + situacao);

        System.out.println("--------------------------------");

        // Exemplo 5 - Ternário encadeado
        int pontuacao = 85;

        String conceito =
                pontuacao >= 90 ? "A" :
                pontuacao >= 80 ? "B" :
                pontuacao >= 70 ? "C" :
                pontuacao >= 60 ? "D" :
                "F";

        System.out.println("Pontuação: " + pontuacao);
        System.out.println("Conceito: " + conceito);
    }
}