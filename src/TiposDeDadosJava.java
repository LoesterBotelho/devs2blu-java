public class TiposDeDadosJava {

    public static void main(String[] args) {

        // ===== TIPOS PRIMITIVOS =====

        boolean ativo = true;
        byte idadeByte = 25;
        short ano = 2026;
        int quantidade = 1000;
        long populacao = 8000000000L;
        float altura = 1.75f;
        double salario = 5500.99;
        char letra = 'A';

        // ===== TIPOS MODERNOS (WRAPPERS E OBJETOS) =====

        Boolean ativoObj = Boolean.TRUE;
        Byte idadeByteObj = 25;
        Short anoObj = 2026;
        Integer quantidadeObj = 1000;
        Long populacaoObj = 8000000000L;
        Float alturaObj = 1.75f;
        Double salarioObj = 5500.99;
        Character letraObj = 'A';

        String nome = "João Silva";

        // ===== SAÍDA DOS DADOS =====

        System.out.println("=== TIPOS PRIMITIVOS ===");
        System.out.println("boolean: " + ativo);
        System.out.println("byte: " + idadeByte);
        System.out.println("short: " + ano);
        System.out.println("int: " + quantidade);
        System.out.println("long: " + populacao);
        System.out.println("float: " + altura);
        System.out.println("double: " + salario);
        System.out.println("char: " + letra);

        System.out.println();

        System.out.println("=== TIPOS MODERNOS (WRAPPERS) ===");
        System.out.println("Boolean: " + ativoObj);
        System.out.println("Byte: " + idadeByteObj);
        System.out.println("Short: " + anoObj);
        System.out.println("Integer: " + quantidadeObj);
        System.out.println("Long: " + populacaoObj);
        System.out.println("Float: " + alturaObj);
        System.out.println("Double: " + salarioObj);
        System.out.println("Character: " + letraObj);
        System.out.println("String: " + nome);
    }
}