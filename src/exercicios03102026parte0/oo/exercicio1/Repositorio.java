package exercicios03102026parte0.oo.exercicio1;

import java.util.List;

public interface Repositorio<T> {

    void adicionar(T objeto);

    void remover(T objeto);

    List<T> listar();

}