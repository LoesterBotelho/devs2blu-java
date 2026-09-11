package minhaannotations.exercicio1;

public class MainTestes {
	public static void main(String[] args) {

		Class<Desenvolvedor> dev = Desenvolvedor.class;

		MyClass info = dev.getAnnotation(MyClass.class);

		System.out.println("Autor: " + info.author());
		System.out.println("Data : " + info.data());
	}

}
