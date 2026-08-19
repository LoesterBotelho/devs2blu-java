package exercicios18082026parte0.oo.exercicio1;

public abstract class EntidadeBase {
    private static int idContador = 0;
    private final int id;

    public EntidadeBase() {
        this.id = ++idContador;
    }

    public EntidadeBase(int idCustomizado) {
        this();
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EntidadeBase that = (EntidadeBase) obj;
        return id == that.id;
    }

    @Override
    public String toString() {
        return "ID: " + id;
    }
}