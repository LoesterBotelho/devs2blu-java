package exercicios20082026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    	
        List<Animal> animais = new ArrayList<>();

        animais.add(new Papagaio("Louro"));
        animais.add(new Cavalo("Spirit"));
        animais.add(new Gato("Felix", "Siamês"));
        animais.add(new Cachorro("Rex", "Grande", "Labrador"));

        for (Animal animal : animais) {
            System.out.println("Animal: " + animal.getNome());
            System.out.println("Som: " + animal.emitirSom());

            if (animal instanceof Mamifero) {
                System.out.println("Comportamento: " + ((Mamifero) animal).amamentar());
            } else if (animal instanceof Ave) {
                System.out.println("Comportamento: " + ((Ave) animal).voar());
            }

            if (animal instanceof AnimalDomestico) {
                ((AnimalDomestico) animal).alimentar();
            }

            if (animal instanceof AnimalEstimacao) {
                ((AnimalEstimacao) animal).brincar();
            }
            System.out.println();
        }
        
    }
}