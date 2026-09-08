package exercicios07092026parte0.oo.exercicio2;

import java.util.Objects;

class CaixaGenerica<T> {
    private Long id;
    private T item;

    public CaixaGenerica() {
    }

    public CaixaGenerica(Long id, T item) {
        this.id = id;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaixaGenerica<?> that = (CaixaGenerica<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CaixaGenerica{id=" + id + ", item=" + item + "}";
    }
}