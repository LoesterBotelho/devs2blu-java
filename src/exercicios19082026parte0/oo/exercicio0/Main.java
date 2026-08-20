package exercicios19082026parte0.oo.exercicio0;

public class Main {
	public static void main(String[] args) {

		Assistente heloisa = new Assistente("134613217","Heloisa" , 3000.00);
				
		Tecnico vanessa = new Tecnico("3312312","vanessa" , 2000.00 , 1000);
			
		Administrativo rafaela = new Administrativo("4123513","rafaela" , 1000.00, "NOITE",50.00);
		
		heloisa.addAumento(1000);
		vanessa.addAumento(2000);
		rafaela.addAumento(3000);
		
		heloisa.exibeDados();
		heloisa.exibirGanhoAnual();
		
		vanessa.exibeDados();
		vanessa.exibirGanhoAnual();
		
		rafaela.exibeDados();
		rafaela.exibirGanhoAnual();
	}
}
