package exercicios20082026parte0.oo.exercicio2;

public class Cavalo extends Mamifero implements AnimalDomestico {
    public Cavalo(String nome) {
        super(nome);
    }

    @Override
    public String emitirSom() {
        return "Relincho";
    }

    @Override
    public String amamentar() {
        return "Cavalo amamentando";
    }

    @Override
    public void alimentar() {
        System.out.println("Alimentando o cavalo");
    }

    @Override
    public void levarVeterinario() {
        System.out.println("Levando cavalo ao veterinário");
    }

    @Override
    public void chamarVeterinario() {
        System.out.println("Chamando veterinário para o cavalo");
    }
}