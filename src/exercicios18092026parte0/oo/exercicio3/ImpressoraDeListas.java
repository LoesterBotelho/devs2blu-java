package exercicios18092026parte0.oo.exercicio3;

import java.util.List;

public class ImpressoraDeListas {

    // O uso de List<?> aceita vistas de qualquer tipo (Wildcard não-delimitado)
    public static void imprimirLista(List<?> lista) {
        for (Object elemento : lista) {
            System.out.println(elemento);
        }
    }
}