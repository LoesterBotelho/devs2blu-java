package minhaannotations.explicacao;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Month;

public class MainTestes {

	public static void main(String[] args) {

		Usuario usuario = new Usuario("Loester", "123.456.789-11", LocalDate.of(1995, Month.MARCH, 14));

		Class<Usuario> minhaClasse = Usuario.class;

		Tabela tabela = minhaClasse.getAnnotation(Tabela.class);

		System.out.println("Tabela: " + tabela.valor());
		System.out.println("--------------------------------");

		for (Field field : minhaClasse.getDeclaredFields()) {

			Campo campo = field.getAnnotation(Campo.class);

			if (campo != null) {
				System.out.println("Campo Java : " + field.getName());
				System.out.println("Campo Banco: " + campo.valor());
			}

			IdadeMinima idadeMinima = field.getAnnotation(IdadeMinima.class);

			if (idadeMinima != null) {

				System.out.println(">> Campo com @IdadeMinima");
				System.out.println("Nome do Campo: " + field.getName());
				System.out.println("Tipo: " + field.getType().getSimpleName());
				System.out.println("Idade mínima: " + idadeMinima.valor());

				try {

					field.setAccessible(true);

					Object valor = field.get(usuario);

					System.out.println("Valor atual: " + valor);

					if (valor instanceof LocalDate data) {

						System.out.println("Ano de nascimento: " + data.getYear());

						System.out.println("Mês: " + data.getMonth());

						System.out.println("Dia: " + data.getDayOfMonth());
					}

				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}

			System.out.println("--------------------------------");
		}
	}
}