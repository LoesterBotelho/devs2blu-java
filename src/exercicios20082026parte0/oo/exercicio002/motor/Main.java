package exercicios20082026parte0.oo.exercicio002.motor;

public class Main {

    public static void main(String[] args) {

    	VeiculoCompleto carro = new Carro();

        carro.ligar();
        carro.mover();
        carro.desligar();
        
        
        ((Veiculo) carro).mover();
        
        ((Motor) carro).ligar();
        ((Motor) carro).desligar();
    }
}