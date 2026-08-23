package exercicios22082026parte0.oo.exercicio0;

import java.util.List;

public final class SqlStatement {

    private final String sql;
    private final List<Object> parameters;

    public SqlStatement(
        String sql,
        List<Object> parameters
    ) {
        this.sql = sql;
        this.parameters = List.copyOf(parameters);
    }

    public String sql() {
        return sql;
    }

    public List<Object> parameters() {
        return parameters;
    }

    @Override
    public String toString() {
        return sql;
    }
}