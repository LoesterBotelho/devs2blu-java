package exercicios07082026parte1.exercicio1;

public class DesenvolvedorMobile extends Desenvolvedor {

private String plataforma;

public DesenvolvedorMobile(
        String nome,
        String cpf,
        double salario,
        String linguagem,
        String plataforma) {

    super(
            nome,
            cpf,
            salario,
            linguagem);

    this.plataforma = plataforma;
}

@Override
public void trabalhar() {

    System.out.println(
            getNome()
            + " está desenvolvendo aplicativo "
            + "para " + plataforma);
}

@Override
public String toString() {
	return "DesenvolvedorMobile [plataforma=" + plataforma + 
			"]";
}

}
