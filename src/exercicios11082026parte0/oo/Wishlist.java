package exercicios11082026parte0.oo;

import java.util.ArrayList;
import java.util.List;

public class Wishlist implements Identifiable<Long> {

    private Long id;
    private Player player;
    private List<Game> games;

    public Wishlist() {
        this.games = new ArrayList<>();
    }

    public Wishlist(
            Long id,
            Player player
    ) {
        this.id = id;
        this.player = player;
        this.games = new ArrayList<>();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void removeGame(Game game) {
        games.remove(game);
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "id=" + id +
                ", player=" + player.getUsername() +
                ", games=" + games +
                '}';
    }
}