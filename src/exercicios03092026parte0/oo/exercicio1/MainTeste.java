package exercicios03092026parte0.oo.exercicio1;

public class MainTeste {
	public static void main(String[] args) {
		
        
        Par<String, Double> alunoNota = new Par<>("Heloisa Moura", 10.0);
        
        
        Par<Integer, String> funcionario = new Par<>(333, "Loester Botelho");
        
        // Latitude: -26.906100
        // Longitude: -49.075400
        Par<Double, Double> coordenadas = new Par<>(-26.906100, -49.075400);


        System.out.println("Par (Nome e Nota do Aluno): " + alunoNota);
        System.out.println("Par (Código e Nome do Funcionário): " + funcionario);
        System.out.println("Par (Coordenadas X e Y): " + coordenadas);
    }
}