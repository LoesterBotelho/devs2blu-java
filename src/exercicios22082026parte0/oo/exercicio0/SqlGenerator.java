package exercicios22082026parte0.oo.exercicio0;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class SqlGenerator {

	public SqlGenerator() {
		this(BancoDados.POSTGRESQL);
	}

	public SqlGenerator(BancoDados bancoDados) {
	}

	public SelectBuilder select(Class<?> entityClass) {
		return new SelectBuilder(entityClass);
	}

	public SqlStatement insert(Object entity) {

		EntityMetadata metadata = EntityMetadata.of(entity.getClass());

		List<CampoMetadata> campos = metadata.campos();

		String nomes = campos.stream().map(CampoMetadata::nome).collect(Collectors.joining(", "));

		String placeholders = campos.stream().map(campo -> "?").collect(Collectors.joining(", "));

		String sql = """
				INSERT INTO %s (%s)
				VALUES (%s);
				""".formatted(metadata.nomeTabela(), nomes, placeholders).stripIndent().trim();

		List<Object> parameters = values(entity, campos);

		return new SqlStatement(sql, parameters);

	}

	public SqlStatement update(Object entity) {

		EntityMetadata metadata = EntityMetadata.of(entity.getClass());

		List<CampoMetadata> ids = metadata.ids();

		if (ids.isEmpty()) {
			throw new IllegalArgumentException("UPDATE precisa de pelo menos um @Id.");

		}

		List<CampoMetadata> campos = metadata.campos().stream().filter(campo -> !campo.id()).toList();

		String set = campos.stream().map(campo -> campo.nome() + " = ?").collect(Collectors.joining(", "));

		String where = ids.stream().map(campo -> campo.nome() + " = ?").collect(Collectors.joining(" AND "));

		String sql = """
				UPDATE %s
				SET %s
				WHERE %s;
				""".formatted(metadata.nomeTabela(), set, where).stripIndent().trim();

		List<Object> parameters = new ArrayList<>(values(entity, campos));

		parameters.addAll(

				values(entity, ids)

		);

		return new SqlStatement(sql, parameters);

	}

	public SqlStatement delete(Object entity) {

		EntityMetadata metadata = EntityMetadata.of(entity.getClass());

		List<CampoMetadata> ids = metadata.ids();

		if (ids.isEmpty()) {
			throw new IllegalArgumentException("DELETE precisa de pelo menos um @Id.");

		}

		String where = ids.stream().map(campo -> campo.nome() + " = ?").collect(Collectors.joining(" AND "));

		String sql = """
				DELETE FROM %s
				WHERE %s;
				""".formatted(metadata.nomeTabela(), where).stripIndent().trim();

		return new SqlStatement(sql, values(entity, ids)

		);

	}

	public String toSql(SqlStatement statement) {

		String sql = statement.sql();

		for (Object parameter : statement.parameters()) {

			String value = formatValue(parameter);

			sql = sql.replaceFirst(

					"\\?",

					java.util.regex.Matcher.quoteReplacement(value)

			);

		}

		return sql;

	}

	private String formatValue(Object value) {

		if (value == null) {

			return "NULL";

		}

		if (value instanceof String) {

			return "'" + value + "'";

		}

		if (value instanceof Character) {

			return "'" + value + "'";

		}

		if (value instanceof Boolean booleanValue) {

			return booleanValue ? "TRUE" : "FALSE";

		}

		return value.toString();

	}

	private List<Object> values(

			Object entity,

			List<CampoMetadata> campos

	) {

		List<Object> values = new ArrayList<>();

		for (CampoMetadata campo : campos) {

			Field field = campo.field();

			try {

				field.setAccessible(true);

				Object value =

						field.get(entity);

				values.add(value);

			} catch (IllegalAccessException exception) {
				throw new IllegalStateException("Não foi possível acessar o campo: " + field.getName(), exception);

			}

		}

		return values;

	}

	public final class SelectBuilder {
		private final Class<?> entityClass;
		private String where;
		private String orderBy;
		private Ordenacao ordenacao;

		private SelectBuilder(Class<?> entityClass) {

			this.entityClass = entityClass;

		}

		public SelectBuilder where(String where) {
			this.where = where;
			return this;
		}

		public SelectBuilder orderBy(String field, Ordenacao ordenacao) {
			this.orderBy = field;
			this.ordenacao = ordenacao;
			return this;

		}

		public String build() {

			EntityMetadata metadata = EntityMetadata.of(entityClass);

			String fields = metadata.campos().stream().map(CampoMetadata::nome).collect(Collectors.joining(", "));

			StringBuilder sql = new StringBuilder();

			sql.append("SELECT ").append(fields).append("\n");

			sql.append("FROM ").append(metadata.nomeTabela()).append("\n");

			if (where != null && !where.isBlank()) {

				sql.append("WHERE ").append(where).append("\n");

			}

			if (orderBy != null && !orderBy.isBlank()) {

				sql.append("ORDER BY ").append(orderBy);

				if (ordenacao != null) {

					sql.append(" ").append(ordenacao);

				}

				sql.append("\n");

			}

			return sql.toString().trim() + ";";

		}

	}

}