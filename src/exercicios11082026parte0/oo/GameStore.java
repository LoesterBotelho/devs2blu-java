package exercicios11082026parte0.oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameStore<T extends Game> implements Identifiable<Long> {

    private Long id;
    private String name;
    private String country;
    private List<T> games;

    public GameStore() {
        this.games = new ArrayList<>();
    }

    public GameStore(
            Long id,
            String name,
            String country
    ) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.games = new ArrayList<>();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public List<T> findByGenre(Genre genre) {
        return games.stream()
                .filter(game -> game.getGenre() == genre)
                .toList();
    }

    public List<T> findAvailableGames() {
        return games.stream()
                .filter(game -> game.getStatus() == GameStatus.AVAILABLE)
                .toList();
    }

    @Override
    public String toString() {
        return "GameStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", games=" + games +
                '}';
    }
}