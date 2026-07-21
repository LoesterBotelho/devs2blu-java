package exercicios20072026parte1.oo.aula1.ex03;

import exercicios20072026parte1.oo.aula1.ex03.implementation.Caminhao;
import exercicios20072026parte1.oo.aula1.ex03.implementation.Carro;
import exercicios20072026parte1.oo.aula1.ex03.implementation.Moto;
import exercicios20072026parte1.oo.aula1.ex03.implementation.Tesla;
import exercicios20072026parte1.oo.aula1.ex03.implementation.Veiculo;
import exercicios20072026parte1.oo.aula1.ex03.interfaces.Abastecivel;
import exercicios20072026parte1.oo.aula1.ex03.interfaces.Eletrico;

public class Main {

    public static void main(String[] args) {

        Veiculo carro = new Carro("Civic", 2022);
        Veiculo moto = new Moto("CBR 600", 2021);
        Veiculo caminhao = new Caminhao("Volvo FH", 2020);
        Veiculo tesla = new Tesla("Model S", 2025);

        Frota frota = new Frota();

        frota.adicionar(carro);
        frota.adicionar(moto);
        frota.adicionar(caminhao);
        frota.adicionar(tesla);

        System.out.println("LISTA DA FROTA");
        frota.listar();

        System.out.println("\nPOLIMORFISMO");
        for (Veiculo v : frota.getVeiculos()) {
            v.ligar();
            v.acelerar(); // chama o método correto de cada classe
            v.desligar();
            System.out.println();
        }

        System.out.println("INTERFACES");
        ((Abastecivel) carro).abastecer(40);
        ((Abastecivel) moto).abastecer(15);
        ((Eletrico) tesla).carregarBateria(80);

        System.out.println("\n MANUTENÇÃO");
        Oficina oficina = new Oficina();
        oficina.revisar(carro);
        oficina.revisar(tesla);

        System.out.println("\nRELATÓRIO E SEGURO");
        new Relatorio().gerar(tesla);
        new Seguro().calcular(tesla);
    }
}