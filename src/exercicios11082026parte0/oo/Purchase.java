package exercicios11082026parte0.oo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Purchase implements Identifiable<Long> {

    private Long id;
    private Player player;
    private Game game;
    private BigDecimal amount;
    private LocalDateTime purchaseDate;
    private PurchaseStatus status;

    public Purchase() {
    }

    public Purchase(
            Long id,
            Player player,
            Game game,
            BigDecimal amount,
            LocalDateTime purchaseDate,
            PurchaseStatus status
    ) {
        this.id = id;
        this.player = player;
        this.game = game;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.status = status;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public PurchaseStatus getStatus() {
        return status;
    }

    public void setStatus(PurchaseStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", player=" + player.getUsername() +
                ", game=" + game.getTitle() +
                ", amount=" + amount +
                ", purchaseDate=" + purchaseDate +
                ", status=" + status +
                '}';
    }
}