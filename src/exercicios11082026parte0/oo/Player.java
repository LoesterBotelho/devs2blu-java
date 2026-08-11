package exercicios11082026parte0.oo;

import java.util.ArrayList;
import java.util.List;

public class Player extends Person {

    private String username;
    private int level;
    private List<Game> games;
    private List<Achievement> achievements;

    public Player() {
        this.games = new ArrayList<>();
        this.achievements = new ArrayList<>();
    }

    public Player(
            Long id,
            String name,
            String email,
            String username,
            int level
    ) {
        super(id, name, email);
        this.username = username;
        this.level = level;
        this.games = new ArrayList<>();
        this.achievements = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void addAchievement(Achievement achievement) {
        achievements.add(achievement);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", username='" + username + '\'' +
                ", level=" + level +
                ", games=" + games +
                ", achievements=" + achievements +
                '}';
    }
}