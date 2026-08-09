package exercicios08082026parte1.oo;

public record Customer(Long id, String name, String email) {

	public Customer {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Invalid id");
		}

		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Invalid name");
		}

		if (email == null || !email.contains("@")) {
			throw new IllegalArgumentException("Invalid email");
		}
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}