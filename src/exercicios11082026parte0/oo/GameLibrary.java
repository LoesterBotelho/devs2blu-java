package exercicios11082026parte0.oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameLibrary<T extends Game> {

    private Long id;
    private Player player;
    private List<T> games;

    public GameLibrary() {
        this.games = new ArrayList<>();
    }

    public GameLibrary(
            Long id,
            Player player
    ) {
        this.id = id;
        this.player = player;
        this.games = new ArrayList<>();
    }

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

    public List<T> getGames() {
        return games;
    }

    public void setGames(List<T> games) {
        this.games = games;
    }

    public void addGame(T game) {
        games.add(game);
    }

    public void removeGame(T game) {
        games.remove(game);
    }

    public Optional<T> findById(Long id) {
        return games.stream()
                .filter(game -> game.getId().equals(id))
                .findFirst();
    }

    public List<T> findByTitle(String title) {
        return games.stream()
                .filter(game -> game.getTitle().equalsIgnoreCase(title))
                .toList();
    }

    @Override
    public String toString() {
        return "GameLibrary{" +
                "id=" + id +
                ", player=" + player.getUsername() +
                ", games=" + games +
                '}';
    }
}