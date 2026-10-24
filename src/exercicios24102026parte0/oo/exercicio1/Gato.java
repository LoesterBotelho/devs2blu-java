package exercicios24102026parte0.oo.exercicio1;

import java.time.LocalDate;

public class Gato extends Animal {
	
    public Gato(Long id, String nome, LocalDate nascimento, Tutor tutor) {
        super(id, nome, nascimento, tutor);
    }

    @Override
    public Especie getEspecie() {
        return Especie.GATO;
    }

    @Override
    public String emitirSom() {
        return "Miau";
    }
    
}