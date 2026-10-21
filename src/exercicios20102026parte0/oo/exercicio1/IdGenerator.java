package exercicios20102026parte0.oo.exercicio1;

import java.util.concurrent.atomic.AtomicLong;

public final class IdGenerator {
    private static final AtomicLong NEXT_ID = new AtomicLong(1);

    private IdGenerator() {}

    public static long nextId() {
        return NEXT_ID.getAndIncrement();
    }
}
