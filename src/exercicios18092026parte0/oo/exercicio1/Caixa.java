package exercicios18092026parte0.oo.exercicio1;

class Caixa<T> {
    private T item;

    public void guardar(T item) {
        this.item = item;
    }

    public T recuperar() {
        return item;
    }
}