package exercicios11082026parte0.oo;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements Identifiable<Long> {

    private Long id;
    private String name;
    private String country;
    private List<Game> games;

    public Publisher() {
        this.games = new ArrayList<>();
    }

    public Publisher(
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

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", games=" + games +
                '}';
    }
}