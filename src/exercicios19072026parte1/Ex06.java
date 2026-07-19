package exercicios19072026parte1;

public class Ex06 {

    private int segundos = 0;

    public Ex06() {
    }

    public Ex06(int segundos) {
        this.segundos = segundos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getHoras() {
        return segundos / 3600;
    }

    public int getMinutos() {
        return (segundos % 3600) / 60;
    }

    public int getSegundosRestantes() {
        return segundos % 60;
    }

    @Override
    public String toString() {
        return "Ex06 [Segundos=" + this.getSegundos()
                + ", Horas=" + this.getHoras()
                + ", Minutos=" + this.getMinutos()
                + ", SegundosRestantes=" + this.getSegundosRestantes()
                + "]";
    }

}