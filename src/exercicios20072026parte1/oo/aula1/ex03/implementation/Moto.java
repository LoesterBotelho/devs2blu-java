package exercicios20072026parte1.oo.aula1.ex03.implementation;

import exercicios20072026parte1.oo.aula1.ex03.interfaces.Abastecivel;

public class Moto extends Veiculo implements Abastecivel {

    public Moto(String modelo, int ano) {
        super(modelo, ano);
    }

    @Override
    public void acelerar() {
        System.out.println(getModelo() + " acelerando a 180 km/h");
    }

    @Override
    public void abastecer(double litros) {
        System.out.println("Moto abastecida com " + litros + " litros");
    }
}