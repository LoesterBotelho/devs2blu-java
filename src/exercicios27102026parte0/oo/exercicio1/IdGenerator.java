package exercicios27102026parte0.oo.exercicio1;

import java.util.concurrent.atomic.AtomicLong;

public final class IdGenerator {

    private static final AtomicLong SEQUENCE = new AtomicLong(1);

    private IdGenerator() {
    }

    public static long nextId() {
        return SEQUENCE.getAndIncrement();
    }
    
}