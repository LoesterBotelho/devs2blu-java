package exemplos;

public class ExemploSwitchNotas {

    public static void main(String[] args) {

        char nota = 'D';

        switch (nota) {

            case 'A':
                System.out.println("Excelente");
                break;

            case 'B':
                System.out.println("Bom");
                break;

            case 'C':
                System.out.println("Regular");
                break;

            case 'D':
                System.out.println("Precisa melhorar");
                break;

            default:
                System.out.println("Nota inválida");
        }
    }
}