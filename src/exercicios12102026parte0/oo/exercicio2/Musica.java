package exercicios12102026parte0.oo.exercicio2;

public class Musica {

	private final String titulo;
    private final String artista;
    private final int duracaoSegundos;

    public Musica(String titulo, String artista, int duracaoSegundos) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracaoSegundos = duracaoSegundos;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista + " - "
                + duracaoSegundos + " segundos";
    }
    
}