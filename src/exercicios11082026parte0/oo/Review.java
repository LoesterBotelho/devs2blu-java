package exercicios11082026parte0.oo;

public class Review implements Identifiable<Long> {

    private Long id;
    private Player player;
    private Game game;
    private int rating;
    private String comment;

    public Review() {
    }

    public Review(
            Long id,
            Player player,
            Game game,
            int rating,
            String comment
    ) {
        this.id = id;
        this.player = player;
        this.game = game;
        this.rating = rating;
        this.comment = comment;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", player=" + player.getUsername() +
                ", game=" + game.getTitle() +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
