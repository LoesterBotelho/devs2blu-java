package exercicios22082026parte0.oo.exercicio0;

import java.util.Arrays;
import java.util.List;

public final class EntityMetadata {

	private final Class<?> entityClass;
	private final Tabela tabela;
	private final List<CampoMetadata> campos;

	private EntityMetadata(Class<?> entityClass, Tabela tabela, List<CampoMetadata> campos) {
		this.entityClass = entityClass;
		this.tabela = tabela;
		this.campos = List.copyOf(campos);
	}

	public static EntityMetadata of(Class<?> entityClass) {

		Tabela tabela = entityClass.getAnnotation(Tabela.class);

		if (tabela == null) {
			throw new IllegalArgumentException("Classe não possui @Tabela: " + entityClass.getName());
		}

		List<CampoMetadata> campos = Arrays.stream(entityClass.getDeclaredFields()).map(field -> {

			Campo campo = field.getAnnotation(Campo.class);

			if (campo == null) {
				return null;
			}

			boolean id = field.isAnnotationPresent(Id.class);

			return new CampoMetadata(field, campo, id);
		}).filter(java.util.Objects::nonNull).toList();

		if (campos.isEmpty()) {
			throw new IllegalArgumentException("Classe não possui campos com @Campo: " + entityClass.getName());
		}

		return new EntityMetadata(entityClass, tabela, campos);
	}

	public Class<?> entityClass() {
		return entityClass;
	}

	public Tabela tabela() {
		return tabela;
	}

	public List<CampoMetadata> campos() {
		return campos;
	}

	public List<CampoMetadata> ids() {
		return campos.stream().filter(CampoMetadata::id).toList();
	}

	public String nomeTabela() {

		String schema = tabela.schema();

		if (schema == null || schema.isBlank()) {
			return tabela.nome();
		}

		return schema + "." + tabela.nome();
	}
}