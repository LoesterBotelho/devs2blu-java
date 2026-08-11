package exercicios10082026parte1.oo;

import java.math.BigDecimal;

public class PixPayment extends Payment {

    private String pixKey;

    public PixPayment() {
        super();
    }

    public PixPayment(
            Long id,
            BigDecimal amount,
            String paymentCode,
            String pixKey) {

        super(id, amount, paymentCode);

        this.pixKey = pixKey;
    }

    @Override
    public String getPaymentType() {
        return "PIX";
    }

    public String getPixKey() {
        return pixKey;
    }

    public void setPixKey(String pixKey) {
        this.pixKey = pixKey;
    }

    @Override
    public String toString() {
        return "PixPayment{" +
                "id=" + getId() +
                ", amount=" + getAmount() +
                ", paymentCode='" + paymentCode + '\'' +
                ", pixKey='" + pixKey + '\'' +
                '}';
    }
}