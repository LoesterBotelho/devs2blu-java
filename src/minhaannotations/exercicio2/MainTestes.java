package minhaannotations.exercicio2;

public class MainTestes {
	public static void main(String[] args) {

		Class<Modulo> dev = Modulo.class;

		Version info = dev.getAnnotation(Version.class);

		System.out.println("Versão : " + info.number());
		System.out.println("Descrição : " + info.description());
		
	}
}
