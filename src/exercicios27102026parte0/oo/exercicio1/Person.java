package exercicios27102026parte0.oo.exercicio1;

import java.util.Objects;

public abstract class Person {

    private final long id;
    private final String name;
    private final String email;

    protected Person(long id, String name, String email) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }

        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Person person)) {
            return false;
        }

        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "%s #%d | %s | %s"
                .formatted(getClass().getSimpleName(), id, name, email);
    }
    
}