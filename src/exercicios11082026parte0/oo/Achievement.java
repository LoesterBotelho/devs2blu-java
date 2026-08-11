package exercicios11082026parte0.oo;

public class Achievement implements Identifiable<Long> {

    private Long id;
    private String name;
    private String description;
    private int points;
    private Game game;

    public Achievement() {
    }

    public Achievement(
            Long id,
            String name,
            String description,
            int points,
            Game game
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.points = points;
        this.game = game;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "Achievement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", points=" + points +
                ", game=" + game.getTitle() +
                '}';
    }
}