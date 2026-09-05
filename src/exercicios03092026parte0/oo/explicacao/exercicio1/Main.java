package exercicios03092026parte0.oo.explicacao.exercicio1;

public class Main {

	public static <T> void imprimeVetor(T v[]) {
		
		for (T item :v) {			
			System.out.println( item + " ");
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Double[] arrayDouble = { 1.1 , 2.2 , 3.3 , 4.4 , 5.5 , 6.6 , 7.7};
		System.out.println("Vetor de Double : ");
		imprimeVetor(arrayDouble);
		
		Integer[] arrayInteger = { 1 , 2 , 3 , 4 , 5 , 6 , 7};
		System.out.println("Vetor de Integer : ");
		imprimeVetor(arrayInteger);		
		
		
		Character[] arrayChar = { 'H' , 'E' , 'L' , 'L' ,'O', ' ' ,  'W' , 'O' , 'R' , 'L' , 'D'};
		System.out.println("Vetor de Character : ");
		imprimeVetor(arrayChar);			
	}
	
}
