package exemplos;

public class EstruturasDecisao {

    public static void main(String[] args) {

        int idade = 20;
        int nota = 75;
        int opcao = 2;
        boolean possuiCarteira = true;

        // 1. IF
        if (idade >= 18) {
            System.out.println("Maior de idade.");
        }

        // 2. IF - ELSE
        if (possuiCarteira) {
            System.out.println("Pode dirigir.");
        } else {
            System.out.println("Não pode dirigir.");
        }

        // 3. IF - ELSE IF - ELSE
        if (nota >= 90) {
            System.out.println("Conceito A");
        } else if (nota >= 70) {
            System.out.println("Conceito B");
        } else if (nota >= 50) {
            System.out.println("Conceito C");
        } else {
            System.out.println("Reprovado");
        }

        // 4. OPERADOR TERNÁRIO
        String resultado = (idade >= 18) ? "Adulto" : "Menor";
        System.out.println("Resultado: " + resultado);

        // 5. SWITCH CASE
        switch (opcao) {
            case 1:
                System.out.println("Opção 1 selecionada");
                break;

            case 2:
                System.out.println("Opção 2 selecionada");
                break;

            case 3:
                System.out.println("Opção 3 selecionada");
                break;

            default:
                System.out.println("Opção inválida");
        }
    }
}