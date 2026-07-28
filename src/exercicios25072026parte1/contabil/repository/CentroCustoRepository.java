package exercicios25072026parte1.contabil.repository;


import java.util.concurrent.atomic.AtomicInteger;

import exercicios25072026parte1.contabil.model.CentroCusto;



public class CentroCustoRepository
        extends MemoryRepository<CentroCusto, Integer> {



    private final AtomicInteger sequencia =
            new AtomicInteger(1);





    @Override
    protected Integer gerarId() {

        return sequencia.getAndIncrement();

    }


}