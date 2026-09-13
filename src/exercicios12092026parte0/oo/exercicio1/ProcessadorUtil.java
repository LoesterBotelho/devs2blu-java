package exercicios12092026parte0.oo.exercicio1;

import java.util.Collection;
import java.util.List;

public class ProcessadorUtil {

	
    public static void imprimirColecao(Collection<? extends Identifiable<?>> itens) {
        for (var item : itens) {
            System.out.println(" -> Item ID: " + item.getId());
        }
    }


    public static <T> void adicionarLote(List<? super T> destino, List<? extends T> origem) {
        destino.addAll(origem);
    }
    
    
}