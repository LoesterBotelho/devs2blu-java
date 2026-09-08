package exercicios07092026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class GerenciadorDeCaixas {
    private Long id;
    private List<CaixaGenerica<?>> caixas;

    public GerenciadorDeCaixas() {
        this.caixas = new ArrayList<>();
    }

    public GerenciadorDeCaixas(Long id, List<CaixaGenerica<?>> caixas) {
        this.id = id;
        this.caixas = caixas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CaixaGenerica<?>> getCaixas() {
        return caixas;
    }

    public void setCaixas(List<CaixaGenerica<?>> caixas) {
        this.caixas = caixas;
    }

    public void adicionarCaixa(CaixaGenerica<?> caixa) {
        this.caixas.add(caixa);
    }

    public void listarItens() {
        for (CaixaGenerica<?> caixa : caixas) {
            System.out.println(caixa);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GerenciadorDeCaixas that = (GerenciadorDeCaixas) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GerenciadorDeCaixas{id=" + id + 
        		", totalCaixas=" + caixas.size() + 
        		"}";
    }
}