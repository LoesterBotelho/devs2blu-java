package exercicios05092026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class MainTestes {

    public static void main(String[] args) {
    	
    	
        List<Desenvolvedor> devs = new ArrayList<>();
        devs.add(new Desenvolvedor("Ana", 5000.0, "Java"));
        devs.add(new Desenvolvedor("Bruno", 6000.0, "Python"));

        exibirFolhaSalarial(devs);

        // ------------------------------------------------------------------------------------------------------
        
        System.out.println();
        
        List<Funcionario> funcionariosGerais = new ArrayList<>();
        
        adicionarFuncionarioPadrao(funcionariosGerais);
        
        exibirFolhaSalarial(funcionariosGerais);
    }


    public static void exibirFolhaSalarial(List<? extends Funcionario> lista) {
    	
        double total = 0;
        
        for (Funcionario f : lista) {
        	
            System.out.println("Nome: " + f.getNome() + " | Salário: R$ " + f.getSalario());
            
            total += f.getSalario();
        }
        
        System.out.println("Total da Folha: R$ " + total);
    }


    public static void adicionarFuncionarioPadrao(List<? super Desenvolvedor> lista) {
    	
        lista.add(new Desenvolvedor("Carlos (Novo)", 4500.0, "JavaScript"));
        
    }
}