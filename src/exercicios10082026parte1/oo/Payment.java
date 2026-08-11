package exercicios10082026parte1.oo;

import java.math.BigDecimal;

public abstract class Payment implements Payable, Identifiable<Long> {

    private Long id;
    private BigDecimal amount;

    protected String paymentCode;

    public Payment() {
    }

    public Payment(
            Long id,
            BigDecimal amount,
            String paymentCode) {

        this.id = id;
        this.amount = amount;
        this.paymentCode = paymentCode;
    }

    public abstract String getPaymentType();

    @Override
    public BigDecimal calculateAmount() {
        return amount;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", amount=" + amount +
                ", paymentCode='" + paymentCode + '\'' +
                '}';
    }
}