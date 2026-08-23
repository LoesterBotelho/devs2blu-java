package exercicios22082026parte0.oo.exercicio0;

import java.lang.reflect.Field;

public class Main {

	public static void main(String[] args) {

		Class<Usuario> classe = Usuario.class;

		Tabela tabela = classe.getAnnotation(Tabela.class);

		System.out.println("""
				----------------------------------------------------------------------------------
				Schema: %s
				Table: %s
				----------------------------------------------------------------------------------
				""".formatted(
					tabela.schema(),
					tabela.nome()
				));

		
		// ----------------------------------------------------------------------------------------------------------------
		
		Field[] fields = classe.getDeclaredFields();

		for (Field field : fields) {

			Campo campo = field.getAnnotation(Campo.class);

			if (campo == null) {

				continue;
			}

			System.out.println("""
					Java Field: %s
					SQL Name: %s
					Type: %s
					Size: %d
					Nullable: %s
					""".formatted(
						field.getName(),
						campo.nome(),
						campo.tipo(),
						campo.tamanho(),
						campo.nullable()
					));

		}

		// ----------------------------------------------------------------------------------------------------------------
		
		SqlGenerator generator = new SqlGenerator(BancoDados.POSTGRESQL);

		String select = generator
				.select(Usuario.class)
				.where("idade > 18")
				.orderBy("nome", Ordenacao.ASC)
				.build();

		Usuario usuario = new Usuario(
				10L,
				"Loester",
				"loester@email.com",
				34
		);

		SqlStatement insert = generator.insert(usuario);

		SqlStatement update = generator.update(usuario);

		SqlStatement delete = generator.delete(usuario);

		System.out.println("""
				----------------------------------------------------------------------------------
				%s
				----------------------------------------------------------------------------------
				%s
				Parameters: %s
				----------------------------------------------------------------------------------
				%s
				Parameters: %s
				----------------------------------------------------------------------------------
				%s
				Parameters: %s
				----------------------------------------------------------------------------------
				""".formatted(
					select,
					insert.sql(),
					insert.parameters(),
					update.sql(),
					update.parameters(),
					delete.sql(),
					delete.parameters()
				));
		
		
		// ----------------------------------------------------------------------------------------------------------------
		
		String select2 = generator
				.select(Usuario.class)
				.where("idade > 18")
				.orderBy("nome", Ordenacao.ASC)
				.build();
		
		String insertSql2 = generator.toSql(insert);

		String updateSql2 = generator.toSql(update);

		String deleteSql2 = generator.toSql(delete);

		System.out.println("""
				----------------------------------------------------------------------------------
				%s
				----------------------------------------------------------------------------------
				%s
				----------------------------------------------------------------------------------
				%s
				----------------------------------------------------------------------------------
				%s
				----------------------------------------------------------------------------------
				""".formatted(
					select2,
					insertSql2,
					updateSql2,
					deleteSql2
				));
		
		
	}

}