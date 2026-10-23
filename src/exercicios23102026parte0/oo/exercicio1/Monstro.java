package exercicios23102026parte0.oo.exercicio1;

public abstract class Monstro extends Entidade {

    private final int forca;
    private final int experienciaRecompensa;

    protected Monstro(
            Long id, String nome, int vida,
            int forca, int experienciaRecompensa) {
        super(id, nome, vida);

        if (forca < 0 || experienciaRecompensa < 0) {
            throw new IllegalArgumentException(
                    "Atributos inválidos");
        }

        this.forca = forca;
        this.experienciaRecompensa = experienciaRecompensa;
    }

    public int getForca() {
        return forca;
    }

    public int getExperienciaRecompensa() {
        return experienciaRecompensa;
    }
}