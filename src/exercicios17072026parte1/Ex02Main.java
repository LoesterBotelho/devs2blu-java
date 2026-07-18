package exercicios17072026parte1;

public class Ex02Main {

	public static void main(String[] args) {
		
		getAuthor();
		
		Ex02 ex02Aluno1 = new Ex02();
		ex02Aluno1.setNome("Maria");
		ex02Aluno1.setNota1(8.5);
		ex02Aluno1.setNota2(7.0);	
		ex02Aluno1.setNota3(8.5);
		ex02Aluno1.setNota4(10.0);
		System.out.println(ex02Aluno1.getNome() + " com média de : " + ex02Aluno1.calcularMediaAritimeticaToString());
		
				
		Ex02 ex02Aluno2 = new Ex02("Jose", 8.85, 7.85, 10.0 , 10.0);
		
		System.out.println(ex02Aluno2.getNome() + " com média de : " + ex02Aluno2.calcularMediaAritimeticaToString());

		
		System.out.println("\n" + ex02Aluno1.toString());
		System.out.println(ex02Aluno2.toString());
				
	}
	
	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");	
		System.out.println("---------------------------------------------------\n");
	}
	
}
