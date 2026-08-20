package exercicios19082026parte0.oo.exercicio3;

public class Professor extends Pessoa implements Cliente {

    private String disciplina;
    private String titulacao;
    private double cargaHoraria;

    public Professor() {
    }

    public Professor(String nome, int idade, String cpf,
                     String disciplina, String titulacao,
                     double cargaHoraria) {

        super(nome, idade, cpf);

        this.disciplina = disciplina;
        this.titulacao = titulacao;
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public void exibirDados() {
        System.out.println(this);
    }

    @Override
    public void realizarCompra() {
        System.out.println("Professor realizou uma compra.");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Professor consultou o saldo.");
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + getNome() + '\'' +
                ", idade=" + getIdade() +
                ", cpf='" + getCpf() + '\'' +
                ", disciplina='" + disciplina + '\'' +
                ", titulacao='" + titulacao + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}