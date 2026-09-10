package collections.d09092026.explicacao.exercicio2;

import java.util.Objects;

class Money implements Comparable<Money> {
	int amount;
	String currencyCode;

	public Money(int amount, String currencyCode) {
		this.amount = amount;
		this.currencyCode = currencyCode;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currencyCode=" + currencyCode + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(amount), currencyCode);
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }

	    if (!(obj instanceof Money other)) {
	        return false;
	    }

	    return amount == other.amount
	            && Objects.equals(currencyCode, other.currencyCode);
	}

	@Override
	public int compareTo(Money outra) {
	    int resultado = this.currencyCode.compareTo(outra.currencyCode);

	    if (resultado != 0) {
	        return resultado;
	    }

	    return Integer.compare(this.amount, outra.amount);
	}
}
