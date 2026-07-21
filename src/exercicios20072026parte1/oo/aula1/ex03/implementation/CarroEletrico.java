package exercicios20072026parte1.oo.aula1.ex03.implementation;

import exercicios20072026parte1.oo.aula1.ex03.interfaces.Eletrico;

public class CarroEletrico extends Carro implements Eletrico {

    public CarroEletrico(String modelo, int ano) {
        super(modelo, ano);
    }

    @Override
    public void carregarBateria(int porcentagem) {
        System.out.println(getModelo() + " carregado em " + porcentagem + "%");
    }

    @Override
    public void acelerar() {
        System.out.println(getModelo() + " acelerando silenciosamente");
    }
}