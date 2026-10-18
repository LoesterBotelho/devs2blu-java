
package exercicios18102026parte0.oo.exercicio1;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    	
    	// -------------------------------------------------------------------------------------------------
        
    	VehicleRepository vehicleRepository = new VehicleRepository();
        CustomerRepository customerRepository = new CustomerRepository();

    	// -------------------------------------------------------------------------------------------------
        
        FleetService fleetService = new FleetService(vehicleRepository);

    	// -------------------------------------------------------------------------------------------------
        
        RentalService rentalService = new RentalService(
                vehicleRepository,
                customerRepository
        );

    	// -------------------------------------------------------------------------------------------------
        
        Vehicle corolla = new Car(
                "V001", "Toyota", "Corolla", 2024, 180.00, 5
        );

        Vehicle cb500 = new Motorcycle(
                "V002", "Honda", "CB 500", 2023, 90.00, 500
        );

        Vehicle volvo = new Truck(
                "V003", "Volvo", "FH", 2022, 450.00, 12000
        );

        Vehicle dolphin = new ElectricCar(
                "V004", "BYD", "Dolphin", 2025, 220.00, 5, 44
        );

    	// -------------------------------------------------------------------------------------------------
        
        fleetService.addVehicle(corolla);
        fleetService.addVehicle(cb500);
        fleetService.addVehicle(volvo);
        fleetService.addVehicle(dolphin);

    	// -------------------------------------------------------------------------------------------------
        
        Customer customer = new Customer(
                "C001",
                "Alex Silva",
                "alex@email.com"
        );

        customerRepository.save(customer);

    	// -------------------------------------------------------------------------------------------------
        
        System.out.println("Frota completa:");
        fleetService.findAll().forEach(System.out::println);

    	// -------------------------------------------------------------------------------------------------
        
        System.out.println("\nFrota ordenada por diária:");
        fleetService.findAll()
                .stream()
                .sorted(Comparator.comparingDouble(Vehicle::getDailyRate))
                .forEach(System.out::println);

    	// -------------------------------------------------------------------------------------------------
        
        System.out.println("\nVeículos disponíveis abaixo de R$ 220:");
        fleetService.findAvailableUnder(220.00)
                .forEach(System.out::println);
        
    	// -------------------------------------------------------------------------------------------------
        
        System.out.println("\nVeículos com diária a partir de R$ 200:");

        List<Vehicle> expensiveVehicles = fleetService.filterVehicles(
                fleetService.findAll(),
                vehicle -> vehicle.getDailyRate() >= 200.00
        );

        expensiveVehicles.forEach(System.out::println);

    	// -------------------------------------------------------------------------------------------------
        
        System.out.println("\nFrota ordenada por marca e modelo:");
        fleetService.findAll()
                .stream()
                .sorted(VehicleComparator.byBrandThenModel())
                .forEach(System.out::println);

        System.out.println("\nLocação:");

        Rental rental = rentalService.rent(
                "R001",
                "C001",
                "V001",
                3
        );

    	// -------------------------------------------------------------------------------------------------
        
        System.out.printf("Total da locação: R$ %.2f%n", rental.calculateTotal());

        System.out.println("\nDevolução:");
        rentalService.returnVehicle("R001");

    	// -------------------------------------------------------------------------------------------------
        
        System.out.println("Veículo disponível novamente: " + corolla.isAvailable());
        
    	// -------------------------------------------------------------------------------------------------
        
    }
}