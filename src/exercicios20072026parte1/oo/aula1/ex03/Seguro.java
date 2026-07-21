package exercicios20072026parte1.oo.aula1.ex03;

import exercicios20072026parte1.oo.aula1.ex03.implementation.Veiculo;

public class Seguro {
    public void calcular(Veiculo v) {
        System.out.println("Seguro calculado para " + v.getModelo());
    }
}