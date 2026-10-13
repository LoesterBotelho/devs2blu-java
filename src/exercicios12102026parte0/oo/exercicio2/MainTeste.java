package exercicios12102026parte0.oo.exercicio2;

public class MainTeste {

    public static void main(String[] args) {

    	Playlist<Musica> playlist = new Playlist<>("Favoritas");

        playlist.adicionar(new Musica("Dreams", "Fleetwood Mac", 257));
        playlist.adicionar(new Musica("Yellow", "Coldplay", 267));
        playlist.adicionar(new Musica("Viva La Vida", "Coldplay", 242));
        playlist.adicionar(new Musica("Billie Jean", "Michael Jackson", 294));

        System.out.println(" PLAYLIST: " + playlist.getNome() + " ");
        playlist.listar().forEach(System.out::println);

        System.out.println("\n MUSICAS DO COLDPLAY ");
        playlist.buscarPorArtista("Coldplay")
                .forEach(System.out::println);

        System.out.println("\n MUSICAS POR DURACAO ");
        playlist.ordenarPorDuracao()
                .forEach(System.out::println);

        System.out.println("\n BUSCAR MUSICA ");
        playlist.buscarPorTitulo("Yellow")
                .ifPresent(System.out::println);

        System.out.println("\nQuantidade: " + playlist.quantidade());

        System.out.println("Duracao total: "
                + playlist.calcularDuracaoTotal() + " segundos");
 
    }
    
}