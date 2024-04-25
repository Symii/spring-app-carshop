package me.symi.carshop;

import me.symi.carshop.entity.*;
import me.symi.carshop.service.AppService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CarshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarshopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppService appService) {
		return runner -> {
			// createEngines(appService);
			// addNewCustomer(appService);
			// saveNewCar(appService);
			// createOrder(appService);
			// addReview(appService);
			// deleteReview(appService);
		};
	}

	private void createEngines(AppService appService) {
		CarEngine engine1 = new CarEngine("TFSI 2.0L", 252, 2.0f,"diesel");
		CarEngine engine2 = new CarEngine("TDI 3.0L", 286, 3.0f,"diesel");
		CarEngine engine3 = new CarEngine("TFSI 2.5:", 400, 2.5f,"benzyna");
		CarEngine engine4 = new CarEngine("40 TDI", 204, 2.0f,"diesel");
		CarEngine engine5 = new CarEngine("TFSI 3.0L", 456, 3.0f,"benzyna");

		System.out.println("Saving engines...");
		appService.saveCarEngine(engine1);
		appService.saveCarEngine(engine2);
		appService.saveCarEngine(engine3);
		appService.saveCarEngine(engine4);
		appService.saveCarEngine(engine5);
		System.out.println("Done.");
	}

	private void deleteReview(AppService appService) {
		System.out.println("Deleting review...");
		appService.deleteReviewById(1);
		System.out.println("Done.");
	}

	private void addReview(AppService appService) {
		Car car = appService.findCarById(1);
		Customer customer = appService.findCustomerById(1);
		Review tempReview = new Review(car, customer, (short) 2, "What a dumb car! Waste of money!!!");

		System.out.println("Adding new review...");
		appService.saveReview(tempReview);
		System.out.println("Done.");
	}

	private void createOrder(AppService appService) {
		Customer customer = appService.findCustomerById(1);
		Car car = appService.findCarById(1);
		Order order = new Order(customer, car);
		System.out.println("Creating new order....");
		appService.saveOrder(order);
		System.out.println("Done.");
	}

	private void addNewCustomer(AppService appService) {
		String hash = "$2a$12$/vLeO2WkzFQDF3l6UbqlaewDEAw.k.np5dh0SWi7CRD9xOlFexRUe"; // test123
		Customer temp1 = new Customer("Anna","Kowalska","Warszawa Mokotow 55","321234764","anna@gmail.com",hash);
		Customer temp2 = new Customer("Michał","Nowak","Słupsk Szczecinska 21","567343223","michal@gmail.com",hash);
		Customer temp3 = new Customer("Maria","Wiśniewska","Gdańsk Wczasowa 5a","690213433","maria@gmail.com",hash);

		System.out.println("Saving new customers...");
		appService.saveCustomer(temp1);
		appService.saveCustomer(temp2);
		appService.saveCustomer(temp3);
		System.out.println("Done.");
	}

	private void saveNewCar(AppService appService) {
		List<CarEngine> engineList = appService.findAllEngines();
		Car car = new Car(engineList.getFirst(), "Audi", "A4 B8", 79500,
				2017, 133400, "manualna", "czarny",
				false, "Dobre auto kontak tel: 123456789");
		System.out.println("Saving car...");
		appService.saveCar(car);
		System.out.println("Car successfuly saved.");
		System.out.println(appService.findAllCars());

	}

}
