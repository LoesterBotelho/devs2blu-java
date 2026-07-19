package exercicios19072026parte2;

public class Aluno {

    private String nome;
    private double[] notas = new double[4];

    public Aluno() {
    }

    public Aluno(String nome, double[] notas) {
        this.nome = nome;
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public double getMediaPonderada() {

        int[] pesos = {2, 3, 4, 1};

        double soma = 0;
        int somaPesos = 0;

        for (int i = 0; i < notas.length; i++) {
            soma += notas[i] * pesos[i];
            somaPesos += pesos[i];
        }

        return soma / somaPesos;
    }

    public String getSituacao() {

        if (getMediaPonderada() >= 7) {
            return "APROVADO";
        }

        if (getMediaPonderada() >= 5) {
            return "RECUPERAÇÃO";
        }

        return "REPROVADO";
    }

    @Override
    public String toString() {

        String texto = "Aluno [Nome=" + nome;

        for (int i = 0; i < notas.length; i++) {
            texto += ", Nota " + (i + 1) + "=" + notas[i];
        }

        texto += ", Média=" + String.format("%.2f", getMediaPonderada());
        texto += ", Situação=" + getSituacao();
        texto += "]";

        return texto;
    }

}