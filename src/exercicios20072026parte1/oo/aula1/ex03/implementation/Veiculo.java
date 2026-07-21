package exercicios20072026parte1.oo.aula1.ex03.implementation;

import exercicios20072026parte1.oo.aula1.ex03.interfaces.Ligavel;
import exercicios20072026parte1.oo.aula1.ex03.interfaces.Manutencao;

public abstract class Veiculo implements Ligavel, Manutencao {

    private String modelo;
    private int ano;

    public Veiculo(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    // método abstrato
    public abstract void acelerar();

    // método virtual
    public void exibirInfo() {
        System.out.println("Modelo: " + modelo + " | Ano: " + ano);
    }

    @Override
    public void ligar() {
        System.out.println(modelo + " ligado.");
    }

    @Override
    public void desligar() {
        System.out.println(modelo + " desligado.");
    }

    @Override
    public void realizarRevisao() {
        System.out.println("Revisão padrão realizada em " + modelo);
    }
}