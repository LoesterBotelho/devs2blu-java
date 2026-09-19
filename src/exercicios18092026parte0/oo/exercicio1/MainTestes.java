package exercicios18092026parte0.oo.exercicio1;

public class MainTestes {
    public static void main(String[] args) {
    	
        // Caixa para String
        Caixa<String> caixaDeTexto = new Caixa<>();
        caixaDeTexto.guardar("Notebook Gamer");
        System.out.println("Item na caixa de texto: " + caixaDeTexto.recuperar());

        // Caixa para Integer
        Caixa<Integer> caixaDeNumero = new Caixa<>();
        caixaDeNumero.guardar(100);
        System.out.println("Item na caixa de número: " + caixaDeNumero.recuperar());
        
    }
}