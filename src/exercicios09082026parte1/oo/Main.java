package exercicios09082026parte1.oo;

public class Main {

	public static void main(String[] args) {

		Address address = new Address("Main Street", "Blumenau", "Brazil");

		Company company = new Company(1L, "Tech Company", address);

		Manager manager = new Manager(1L, "John Manager", "john@company.com", 15000.0, "M001", "Engineering");

		Developer developer = new Developer(2L, "Alice Developer", "alice@company.com", 10000.0, "D001", "Engineering",  "Java");

		SeniorDeveloper seniorDeveloper = new SeniorDeveloper(3L, "Bob Senior", "bob@company.com", 18000.0, "SD001", "Engineering", "Java", 10);

		Customer customer = new Customer(10L, "Michael Customer", "michael@customer.com", "Customer Company");

		Department department = new Department(1L, "Engineering", manager);

		Project project = new Project(1L, "Banking API", customer);

		company.addEmployee(manager);
		company.addEmployee(developer);
		company.addEmployee(seniorDeveloper);

		company.addProject(project);

		department.addEmployee(developer);
		department.addEmployee(seniorDeveloper, true);

		manager.addEmployee(developer);
		manager.addEmployee(seniorDeveloper);

		project.addEmployee(developer, seniorDeveloper, manager);

		developer.work();
		seniorDeveloper.work();
		manager.work();

		developer.writeCode();
		developer.writeCode("Banking API");

		System.out.println(developer.calculateSalary());

		System.out.println(developer.calculateSalary(1000));

		System.out.println(developer.calculateSalary(1000, 500));

		manager.printPayment();

		developer.generateReport();

		seniorDeveloper.mentor();

		customer.requestProject();

		System.out.println();

		System.out.println(company);

		System.out.println(department);

		System.out.println(project);

		System.out.println(developer);

		System.out.println(seniorDeveloper);

		System.out.println(customer);

		System.out.println();

		Person person1 = developer;
		Person person2 = customer;

		System.out.println(person1.getRole());

		System.out.println(person2.getRole());

		Employee employee = seniorDeveloper;

		employee.work();

		if (employee instanceof SeniorDeveloper senior) {
			senior.mentor();
		}

		Repository<Employee> employeeRepository = new Repository<>();

		employeeRepository.save(manager);
		employeeRepository.save(developer);
		employeeRepository.save(seniorDeveloper);

		System.out.println(employeeRepository.count());

		for (Employee item : employeeRepository.findAll()) {

			System.out.println(item);
		}

		Repository<Customer> customerRepository = new Repository<>();

		customerRepository.save(customer);

		System.out.println(customerRepository.findFirst());

		System.out.println(developer.equals(seniorDeveloper));

		System.out.println(developer.getBasicInfo());

		System.out.println();
		System.out.println("INSTANCEOF");
		System.out.println("developer instanceof Person: " + (developer instanceof Person));
		System.out.println("developer instanceof Employee: " + (developer instanceof Employee));
		System.out.println("developer instanceof Developer: " + (developer instanceof Developer));
		System.out.println("developer instanceof SeniorDeveloper: " + (developer instanceof SeniorDeveloper));

		System.out.println();
		System.out.println("seniorDeveloper instanceof Person: " + (seniorDeveloper instanceof Person));
		System.out.println("seniorDeveloper instanceof Employee: " + (seniorDeveloper instanceof Employee));
		System.out.println("seniorDeveloper instanceof Developer: " + (seniorDeveloper instanceof Developer));
		System.out.println("seniorDeveloper instanceof SeniorDeveloper: " + (seniorDeveloper instanceof SeniorDeveloper));

		System.out.println();
		System.out.println("manager instanceof Person: " + (manager instanceof Person));
		System.out.println("manager instanceof Employee: " + (manager instanceof Employee));
		System.out.println("manager instanceof Manager: " + (manager instanceof Manager));

		System.out.println();
		System.out.println("customer instanceof Person: " + (customer instanceof Person));
		System.out.println("customer instanceof Customer: " + (customer instanceof Customer));

	}
}