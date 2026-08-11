package exercicios11082026parte0.oo;

import java.time.LocalDateTime;

public class GameSession implements Identifiable<Long> {

    private Long id;
    private Player player;
    private Game game;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int score;

    public GameSession() {
    }

    public GameSession(
            Long id,
            Player player,
            Game game,
            LocalDateTime startTime,
            LocalDateTime endTime,
            int score
    ) {
        this.id = id;
        this.player = player;
        this.game = game;
        this.startTime = startTime;
        this.endTime = endTime;
        this.score = score;
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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "GameSession{" +
                "id=" + id +
                ", player=" + player.getUsername() +
                ", game=" + game.getTitle() +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", score=" + score +
                '}';
    }
}
