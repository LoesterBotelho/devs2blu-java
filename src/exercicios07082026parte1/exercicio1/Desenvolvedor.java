package exercicios07082026parte1.exercicio1;

public class Desenvolvedor extends Funcionario {

    private String linguagem;

    public Desenvolvedor(
            String nome,
            String cpf,
            double salario,
            String linguagem) {

        super(nome, cpf, salario);

        this.linguagem = linguagem;
    }

    @Override
    public void trabalhar() {

        System.out.println(
                getNome()
                + " está desenvolvendo software em "
                + linguagem);
    }

    public String getLinguagem() {
        return linguagem;
    }

	@Override
	public String toString() {
		return "Desenvolvedor [linguagem=" + linguagem + 
				"]";
	}
    
    
}