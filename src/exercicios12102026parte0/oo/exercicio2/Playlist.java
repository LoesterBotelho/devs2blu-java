package exercicios12102026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Playlist<T extends Musica> {

	private final String nome;
    private final List<T> musicas = new ArrayList<>();

    public Playlist(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionar(T musica) {
        musicas.add(musica);
    }

    public List<T> listar() {
        return List.copyOf(musicas);
    }

    public List<T> buscarPorArtista(String artista) {
        return musicas.stream()
                .filter(musica -> musica.getArtista().equalsIgnoreCase(artista))
                .toList();
    }

    public List<T> ordenarPorDuracao() {
        return musicas.stream()
                .sorted(Comparator.comparingInt(Musica::getDuracaoSegundos))
                .toList();
    }

    public Optional<T> buscarPorTitulo(String titulo) {
        return musicas.stream()
                .filter(musica -> musica.getTitulo().equalsIgnoreCase(titulo))
                .findFirst();
    }

    public int calcularDuracaoTotal() {
        return musicas.stream()
                .mapToInt(Musica::getDuracaoSegundos)
                .sum();
    }

    public int quantidade() {
        return musicas.size();
    }
    
}