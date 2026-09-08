package exercicios07092026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class RegistroGenerico<T> {
    private Long id;
    private T dado;

    public RegistroGenerico() {
    }

    public RegistroGenerico(Long id, T dado) {
        this.id = id;
        this.dado = dado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistroGenerico<?> that = (RegistroGenerico<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RegistroGenerico{id=" + id + ", dado=" + dado + "}";
    }
}

class ProcessadorDeRegistros {
    private Long id;
    private List<RegistroGenerico<?>> registros;

    public ProcessadorDeRegistros() {
        this.registros = new ArrayList<>();
    }

    public ProcessadorDeRegistros(Long id, List<RegistroGenerico<?>> registros) {
        this.id = id;
        this.registros = registros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RegistroGenerico<?>> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroGenerico<?>> registros) {
        this.registros = registros;
    }

    public void adicionar(RegistroGenerico<?> registro) {
        this.registros.add(registro);
    }

    public void exibirRegistros() {
        for (RegistroGenerico<?> reg : registros) {
            System.out.println(reg);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessadorDeRegistros that = (ProcessadorDeRegistros) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ProcessadorDeRegistros{id=" + id + 
        		", totalRegistros=" + registros.size() + 
        		"}";
    }
}