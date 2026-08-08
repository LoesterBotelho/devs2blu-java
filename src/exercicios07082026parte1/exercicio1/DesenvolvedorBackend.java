package exercicios07082026parte1.exercicio1;

public class DesenvolvedorBackend
extends Desenvolvedor {

private String framework;

public DesenvolvedorBackend(
    String nome,
    String cpf,
    double salario,
    String linguagem,
    String framework) {

super(
        nome,
        cpf,
        salario,
        linguagem);

this.framework = framework;
}

@Override
public void trabalhar() {

System.out.println(
        getNome()
        + " está desenvolvendo APIs usando "
        + framework);
}

public String getFramework() {
return framework;
}

@Override
public String toString() {
	return "DesenvolvedorBackend [framework=" + framework + 
			"]";
}


}
