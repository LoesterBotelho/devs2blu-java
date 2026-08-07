package exercicios060082026.parte0.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Contato contato1 = new Contato("Jose","(47) 9888-8214","jose@gmail.com");
		
		Contato contato2 = new Contato("Maria","(47) 9877-4284","maria@gmail.com");
		
		Contato contato3 = new Contato("Loester","(47) 9833-5234","loester@gmail.com");
		
		List<Contato> listaContatos = new ArrayList<Contato>(); 
		
		listaContatos.add(contato1);
		listaContatos.add(contato2);
		listaContatos.add(contato3);
		
		Agenda agenda = new Agenda("Agenda Pessoal", listaContatos);
		
		
		System.out.println(agenda.toString()); 
		
		
	}
}
