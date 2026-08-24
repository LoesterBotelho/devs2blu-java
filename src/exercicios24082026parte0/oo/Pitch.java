package exercicios24082026parte0.oo;

import exercicios24082026parte0.oo.exercicio1.Avaliavel;

public class Pitch implements Avaliavel {
    private String problema;
    private String solucao;
    private boolean apresentadoEmIngles;
    private double notaProblema;
    private double notaSolucao;
    private double notaApresentacao;

    public Pitch(String problema, String solucao, boolean apresentadoEmIngles) {
        this.problema = problema;
        this.solucao = solucao;
        this.apresentadoEmIngles = apresentadoEmIngles;
    }

    @Override
    public double calcularPontuacaoFinal() {
        double baseNota = (notaProblema + notaSolucao + notaApresentacao) / 3.0;

        double pontuacaoFinal = apresentadoEmIngles ? baseNota * 1.1 : baseNota;
        
        return Math.min(pontuacaoFinal, 10.0);
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public boolean isApresentadoEmIngles() {
        return apresentadoEmIngles;
    }

    public void setApresentadoEmIngles(boolean apresentadoEmIngles) {
        this.apresentadoEmIngles = apresentadoEmIngles;
    }

    public double getNotaProblema() {
        return notaProblema;
    }

    public void setNotaProblema(double notaProblema) {
        validarNota(notaProblema);
        this.notaProblema = notaProblema;
    }

    public double getNotaSolucao() {
        return notaSolucao;
    }

    public void setNotaSolucao(double notaSolucao) {
        validarNota(notaSolucao);
        this.notaSolucao = notaSolucao;
    }

    public double getNotaApresentacao() {
        return notaApresentacao;
    }

    public void setNotaApresentacao(double notaApresentacao) {
        validarNota(notaApresentacao);
        this.notaApresentacao = notaApresentacao;
    }

    private void validarNota(double nota) {
        if (nota < 0.0 || nota > 10.0) {
            throw new IllegalArgumentException("A nota deve estar compreendida entre 0.0 e 10.0.");
        }
    }

    @Override
    public String toString() {
        return "Pitch [problema=" + problema + 
                ", solucao=" + solucao + 
                ", apresentadoEmIngles=" + apresentadoEmIngles + 
                ", notaProblema=" + notaProblema + 
                ", notaSolucao=" + notaSolucao + 
                ", notaApresentacao=" + notaApresentacao + 
                ", pontuacaoFinal=" + String.format("%.2f", calcularPontuacaoFinal()) + "]";
    }
}