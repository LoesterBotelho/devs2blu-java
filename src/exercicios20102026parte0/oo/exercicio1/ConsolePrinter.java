package exercicios20102026parte0.oo.exercicio1;

public final class ConsolePrinter {
    private ConsolePrinter() {}

    public static void title(String title) {
        System.out.println();
        System.out.println(title);
    }

    public static void line(String text) {
        System.out.println(text);
    }
}
