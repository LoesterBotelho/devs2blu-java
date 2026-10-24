package exercicios24102026parte0.oo.exercicio1;

import java.time.LocalDate;

public class Cachorro extends Animal {
	
    public Cachorro(Long id, String nome, LocalDate nascimento, Tutor tutor) {
        super(id, nome, nascimento, tutor);
    }

    @Override
    public Especie getEspecie() {
        return Especie.CACHORRO;
    }

    @Override
    public String emitirSom() {
        return "Au au";
    }
    
}