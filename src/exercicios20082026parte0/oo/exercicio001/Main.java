package exercicios20082026parte0.oo.exercicio001;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Contabilizavel> documentos = List.of(
                new Empenho(),
                new LiquidacaoProcessada(),
                new LiquidacaoNaoProcessada(),
                new PagamentoOrcamentario(),
                new PagamentoExtraorcamentario(),
                new LoteLancamentos(),
                new TransferenciaAjusteFontes(),
                new TransferenciaEntreContas()
        );

        documentos.forEach(Contabilizavel::contabilizar);
        
        
        Object obj = new Empenho();
        
        if (obj instanceof Contabilizavel) {        
        	System.out.println("Implementa Contabilizavel");        
        }
        
        if (obj instanceof Contabilizavel contabilizavel) {     
        	contabilizavel.contabilizar();      
        	}
        
    }
}