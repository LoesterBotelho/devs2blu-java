package exercicios20072026parte1.oo.aula1.ex03;

import java.util.ArrayList;
import java.util.List;

import exercicios20072026parte1.oo.aula1.ex03.implementation.Veiculo;

public class Frota {

    private List<Veiculo> veiculos = new ArrayList<>();

    public void adicionar(Veiculo v) {
        veiculos.add(v);
    }

    public void listar() {
        for (Veiculo v : veiculos) {
            v.exibirInfo(); // polimorfismo
        }
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
}