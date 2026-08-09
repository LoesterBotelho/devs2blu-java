package exercicios08082026parte1.oo;

import java.math.BigDecimal;

public final class Book extends Product {

	private final String author;

	public Book(Long id, String name, BigDecimal price, String author) {
		super(id, name, price);

		if (author == null || author.isBlank()) {
			throw new IllegalArgumentException("Invalid author");
		}

		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String getDescription() {
		return getName() + " by " + author;
	}

	@Override
	public String getCategory() {
		return "BOOK";
	}

	@Override
	public String toString() {
		return "Book [author=" + author + "]";
	}

}