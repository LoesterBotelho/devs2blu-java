package exercicios18092026parte0.oo.exercicio4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemovedorDuplicadas {

    public static List<String> removerDuplicadas(List<String> listaComDuplicadas) {
        
    	// O HashSet elimina duplicatas automaticamente
        Set<String> conjuntoUnico = new HashSet<>(listaComDuplicadas);
        
        // Retornamos convertendo de volta para uma List
        return new ArrayList<>(conjuntoUnico);
    }

}