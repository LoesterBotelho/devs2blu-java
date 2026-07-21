package exercicios20072026parte1.oo.aula1.ex03;

import exercicios20072026parte1.oo.aula1.ex03.implementation.Veiculo;

public class Relatorio {
    public void gerar(Veiculo v) {
        System.out.println("Relatório do veículo: " + v.getModelo());
    }
}