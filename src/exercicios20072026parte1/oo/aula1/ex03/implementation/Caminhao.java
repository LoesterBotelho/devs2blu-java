package exercicios20072026parte1.oo.aula1.ex03.implementation;

import exercicios20072026parte1.oo.aula1.ex03.interfaces.Abastecivel;

public class Caminhao extends Veiculo implements Abastecivel {

    public Caminhao(String modelo, int ano) {
        super(modelo, ano);
    }

    @Override
    public void acelerar() {
        System.out.println(getModelo() + " acelerando com carga pesada");
    }

    @Override
    public void abastecer(double litros) {
        System.out.println("Caminhão abastecido com " + litros + " litros");
    }
}