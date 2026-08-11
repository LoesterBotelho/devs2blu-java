package exercicios11082026parte0.oo;

import java.util.ArrayList;
import java.util.List;

public class Developer extends Person {

    private String studioName;
    private String country;
    private List<Game> games;

    public Developer() {
        this.games = new ArrayList<>();
    }

    public Developer(
            Long id,
            String name,
            String email,
            String studioName,
            String country
    ) {
        super(id, name, email);
        this.studioName = studioName;
        this.country = country;
        this.games = new ArrayList<>();
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
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
        return "Developer{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", studioName='" + studioName + '\'' +
                ", country='" + country + '\'' +
                ", games=" + games +
                '}';
    }
}