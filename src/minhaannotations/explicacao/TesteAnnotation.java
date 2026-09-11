package minhaannotations.explicacao;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;

public class TesteAnnotation {

	public static void main(String[] args) {

		Usuario usuario = new Usuario("Loester", "123.456.789-11", LocalDate.of(1995, 3, 14));

		System.out.println(Validador(usuario));
	}

	public static <T> boolean Validador(T objeto) {

		Class<?> classe = objeto.getClass();

		for (Field field : classe.getDeclaredFields()) {

			if (field.isAnnotationPresent(IdadeMinima.class)) {

				try {

					IdadeMinima idadeMinima = field.getAnnotation(IdadeMinima.class);

					// Libera o acesso ao atributo privado.
					field.setAccessible(true);

					LocalDate dataNascimento = (LocalDate) field.get(objeto);

					int idade = Period.between( dataNascimento, LocalDate.now() ).getYears();

					System.out.println(Period.between( dataNascimento, LocalDate.now() ));
					System.out.println("Ano atual: " + LocalDate.now().toString());
					System.out.println("Campo: " + field.getName());
					System.out.println("Ano: " + dataNascimento.getYear());
					System.out.println("Idade atual: " + idade);
					System.out.println("Idade mínima: " + idadeMinima.valor());
								
					return idade >= idadeMinima.valor();

				} catch (IllegalAccessException e) {
					e.printStackTrace();
					return false;
				}
			}
		}

		return true;
	}
}