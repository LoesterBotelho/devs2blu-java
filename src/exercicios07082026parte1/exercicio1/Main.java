package exercicios07082026parte1.exercicio1;

public class Main {

	public static void main(String[] args) {

		Empresa empresa = new Empresa("OutSource Software");

		empresa.criarDepartamento("Tecnologia");
		empresa.criarDepartamento("Gestão");

		empresa.listarDepartamentos();

		Desenvolvedor dev = new Desenvolvedor("Jose", "223.655.470-28", 6000, "Java");

		DesenvolvedorBackend backend = new DesenvolvedorBackend("Loester", "190.463.160-68", 5000, "Java", "Spring Boot");
		DesenvolvedorMobile mobile = new DesenvolvedorMobile("Ana", "107.797.590-28", 4000, "Kotlin", "Android");
		Gerente gerente = new Gerente("Maria", "617.948.180-65", 12000, "Tecnologia");

		Departamento tecnologia = empresa.buscarDepartamento("Tecnologia");

		tecnologia.adicionarFuncionario(dev);
		tecnologia.adicionarFuncionario(backend);
		tecnologia.adicionarFuncionario(mobile);

		Departamento gestao = empresa.buscarDepartamento("Gestão");

		gestao.adicionarFuncionario(gerente);

		tecnologia.listarFuncionarios();

		gestao.listarFuncionarios();

		Projeto projeto = new Projeto("Sistema RH");

		projeto.adicionarFuncionario(backend);
		projeto.adicionarFuncionario(mobile);
		projeto.adicionarFuncionario(gerente);

		projeto.listarEquipe();

		Funcionario funcionario1 = dev;
		Funcionario funcionario2 = backend;
		Funcionario funcionario3 = mobile;
		Funcionario funcionario4 = gerente;

		System.out.println("\nPOLIMORFISMO");

		funcionario1.trabalhar();
		funcionario2.trabalhar();
		funcionario3.trabalhar();
		funcionario4.trabalhar();

		System.out.println("\nEQUIPE");

		projeto.executarProjeto();

		System.out.println("\nFUNCIONÁRIO");

		backend.apresentar();

		System.out.println("\nSalário antes: " + backend.getSalario());

		backend.aumentarSalario(10);

		System.out.println("Salário depois: " + backend.getSalario());
	}
}