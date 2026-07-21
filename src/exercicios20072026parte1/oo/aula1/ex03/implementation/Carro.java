package exercicios20072026parte1.oo.aula1.ex03.implementation;

import exercicios20072026parte1.oo.aula1.ex03.interfaces.Abastecivel;

public class Carro extends Veiculo implements Abastecivel {

    public Carro(String modelo, int ano) {
        super(modelo, ano);
    }

    @Override
    public void acelerar() {
        System.out.println(getModelo() + " acelerando a 120 km/h");
    }

    @Override
    public void abastecer(double litros) {
        System.out.println("Carro abastecido com " + litros + " litros");
    }

    @Override
    public void exibirInfo() {
        System.out.println("[CARRO]");
        super.exibirInfo();
    }
}