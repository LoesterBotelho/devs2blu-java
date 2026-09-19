package exercicios18092026parte0.oo.exercicio2;

;

public class MainTestes {

    public static void main(String[] args) {
    	
        // Testando com Inteiros
        Integer[] numeros = {10, 45, 2, 89, 33};
        Integer maiorNumero = ValidadorUtilitarios.encontrarMaior(numeros);
        System.out.println("O maior número é: " + maiorNumero); // Deve imprimir 89

        // Testando com Strings (ordem alfabética)
        String[] linguagens = {"Java", "Python", "C++", "JavaScript"};
        String maiorString = ValidadorUtilitarios.encontrarMaior(linguagens);
        System.out.println("A maior string é: " + maiorString); // Deve imprimir Python
        
    }
}