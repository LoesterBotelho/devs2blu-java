package exercicios11082026parte0.oo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Game implements Identifiable<Long> {

    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private Genre genre;
    private Platform platform;
    private GameStatus status;
    private Developer developer;
    private Publisher publisher;
    private List<Review> reviews;
    private List<Achievement> achievements;

    public Game() {
        this.reviews = new ArrayList<>();
        this.achievements = new ArrayList<>();
    }

    public Game(
            Long id,
            String title,
            String description,
            BigDecimal price,
            Genre genre,
            Platform platform,
            GameStatus status,
            Developer developer,
            Publisher publisher
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.genre = genre;
        this.platform = platform;
        this.status = status;
        this.developer = developer;
        this.publisher = publisher;
        this.reviews = new ArrayList<>();
        this.achievements = new ArrayList<>();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void addAchievement(Achievement achievement) {
        achievements.add(achievement);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", genre=" + genre +
                ", platform=" + platform +
                ", status=" + status +
                ", developer=" + developer.getStudioName() +
                ", publisher=" + publisher.getName() +
                ", reviews=" + reviews +
                ", achievements=" + achievements +
                '}';
    }
}