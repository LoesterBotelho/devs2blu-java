package exemplos;

public class ExemploCompletoJava {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        int c = 5;

        System.out.println("=== OPERADORES ARITMÉTICOS ===");
        System.out.println("a + b = " + (a + b));
        System.out.println("b - a = " + (b - a));
        System.out.println("a * c = " + (a * c));
        System.out.println("b / c = " + (b / c));
        System.out.println("b % a = " + (b % a));

        System.out.println("\n=== CLASSE MATH ===");
        System.out.println("Math.abs(-1.23) = " + Math.abs(-1.23));
        System.out.println("Math.pow(3,2) = " + Math.pow(3, 2));
        System.out.println("Math.sqrt(121) = " + Math.sqrt(121));
        System.out.println("Math.sqrt(256) = " + Math.sqrt(256));
        System.out.println("Math.min(-3,-5) = " + Math.min(-3, -5));
        System.out.println("Math.abs(Math.min(-3,-5)) = "
                + Math.abs(Math.min(-3, -5)));
        System.out.println("Math.max(a,b) = " + Math.max(a, b));

        System.out.println("\n=== OPERADORES RELACIONAIS ===");
        System.out.println(a == b);
        System.out.println(a != b);
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(b >= a);
        System.out.println(b <= a);

        System.out.println("\n=== IF / ELSE ===");

        if (a > b) {
            System.out.println("a é maior que b");
        } else {
            System.out.println("a não é maior que b");
        }

        if (a == 10) {
            System.out.println("a vale 10");
        } else if (a > 10) {
            System.out.println("a é maior que 10");
        } else {
            System.out.println("a é menor que 10");
        }

        System.out.println("\n=== OPERADOR AND (&&) ===");

        if (a == 10 && b == 20) {
            System.out.println("a = 10 E b = 20");
        }

        if (a < b && c < a) {
            System.out.println("As duas condições são verdadeiras");
        }

        System.out.println("\n=== OPERADOR OR (||) ===");

        if (a > b || b > a) {
            System.out.println("Pelo menos uma condição é verdadeira");
        }

        if (a == 100 || b == 20) {
            System.out.println("Uma das condições foi satisfeita");
        }

        System.out.println("\n=== OPERADOR NOT (!) ===");

        boolean ativo = false;

        if (!ativo) {
            System.out.println("Usuário está inativo");
        }

        if (!(a > b)) {
            System.out.println("NÃO é verdade que a > b");
        }

        System.out.println("\n=== CONDIÇÕES COMPLEXAS ===");

        if ((a < b && c < b) || a == 100) {
            System.out.println("Condição complexa 1 verdadeira");
        }

        if (!(a == b) && (b > a || c > b)) {
            System.out.println("Condição complexa 2 verdadeira");
        }

        if (a > 0 && b > 0 && c > 0) {
            System.out.println("Todos os números são positivos");
        }

        System.out.println("\n=== EXEMPLO FINAL ===");

        int idade = 25;
        boolean possuiCarteira = true;

        if (idade >= 18 && possuiCarteira) {
            System.out.println("Pode dirigir");
        } else {
            System.out.println("Não pode dirigir");
        }
    }
}
