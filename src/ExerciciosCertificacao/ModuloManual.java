package ExerciciosCertificacao;

public class ModuloManual {

    public static int calcularModulo(int dividendo, int divisor) {

        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor não pode ser zero.");
        }

        int quociente = dividendo / divisor;
        int resto = dividendo - (quociente * divisor);

        return resto;
    }

    public static void main(String[] args) {
    	
    	int a = 10;
    	int b = 3;
        int resultado = calcularModulo(a, b);

        System.out.println("Resto: " + resultado);
        System.out.println("Resto: " + (a % b));
    }
}