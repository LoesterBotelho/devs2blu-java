package exercicios17072026;

public class Ex02Main {

	public static void main(String[] args) {
		
		getAuthor();
		
		Ex02 ex02Aluno1 = new Ex02();
		ex02Aluno1.setNota1(8.9);
		ex02Aluno1.setNota2(7.0);		
		System.out.println("Aluno1 com média de : " + ex02Aluno1.calcularMediaAritimeticaToString());
		ex02Aluno1.toString();
				
		Ex02 ex02Aluno2 = new Ex02();
		ex02Aluno2.setNota1(4.5);
		ex02Aluno2.setNota2(6);		
		System.out.println("Aluno2 com média de : " + ex02Aluno2.calcularMediaAritimeticaToString());
		ex02Aluno2.toString();
				
	}
	
	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");	
		System.out.println("---------------------------------------------------\n");
	}
	
}
