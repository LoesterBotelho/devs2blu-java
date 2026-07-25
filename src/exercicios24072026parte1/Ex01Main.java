package exercicios24072026parte1;

public class Ex01Main {

	public static void main(String[] args) {

		int anos = 0;
		double chico = 1.50;
		double crescimentoChico = 0.02;
		double atualChico = 0.0;
		
		double juca = 1.10;
		double crescimentoJuca = 0.03;			
		double atualJuca =  0.0;
		
		atualChico += chico;
		atualJuca +=  juca;		
		
		System.out.println("anos : 0 | atualJuca > atualChico => " + atualJuca + " > " + atualChico + " | bol = " + !(atualJuca > atualChico));
		
		while ( !(atualJuca > atualChico) ) {
								
			atualChico += crescimentoChico;
			atualJuca +=  crescimentoJuca;
			anos++;
			
			System.out.println("anos : " +  anos  + " | atualJuca > atualChico => " + atualJuca + " > " + atualChico + " | bol = " + !(atualJuca > atualChico));
	
		}
		
		System.out.println("Juca ficou maior que no ano : " + anos);
		
	}
	
}
