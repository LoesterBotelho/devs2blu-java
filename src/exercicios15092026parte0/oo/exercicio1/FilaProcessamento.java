package exercicios15092026parte0.oo.exercicio1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class FilaProcessamento<T> {

    private final Queue<T> fila =
            new ArrayDeque<>();

    private final Deque<T> historico =
            new ArrayDeque<>();

    public void adicionar(T item) {
        fila.offer(item);
    }

    public T processar() {

        T item = fila.poll();

        if (item != null) {
            historico.push(item);
        }

        return item;
    }

    public int tamanhoFila() {
        return fila.size();
    }

    public int tamanhoHistorico() {
        return historico.size();
    }

}