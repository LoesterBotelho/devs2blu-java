package exercicios10082026parte1.oo;

import java.math.BigDecimal;

public class CreditCardPayment extends Payment {

    private String cardHolder;
    private String lastFourDigits;

    public CreditCardPayment() {
        super();
    }

    public CreditCardPayment(
            Long id,
            BigDecimal amount,
            String paymentCode,
            String cardHolder,
            String lastFourDigits) {

        super(id, amount, paymentCode);

        this.cardHolder = cardHolder;
        this.lastFourDigits = lastFourDigits;
    }

    @Override
    public String getPaymentType() {
        return "Credit Card";
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getLastFourDigits() {
        return lastFourDigits;
    }

    public void setLastFourDigits(String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }

    @Override
    public String toString() {
        return "CreditCardPayment{" +
                "id=" + getId() +
                ", amount=" + getAmount() +
                ", paymentCode='" + paymentCode + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", lastFourDigits='" + lastFourDigits + '\'' +
                '}';
    }
}