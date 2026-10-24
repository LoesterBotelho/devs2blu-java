package exercicios24102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Tutor extends Pessoa {
	
    private final List<Animal> animais = new ArrayList<>();

    public Tutor(Long id, String nome, String telefone) {
        super(id, nome, telefone);
    }

    public void adicionarAnimal(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Animal obrigatório");
        }

        if (animais.stream().noneMatch(a -> a.getId().equals(animal.getId()))) {
            animais.add(animal);
        }
    }

    public List<Animal> getAnimais() {
        return List.copyOf(animais);
    }
    
}