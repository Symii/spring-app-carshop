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
			// saveNewCar(appService);
			// addNewCustomer(appService);
			// createOrder(appService);
			// addReview(appService);
			// deleteReview(appService);
		};
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
		Customer temp1 = new Customer("Anna","Kowalska","Warszawa Mokotow 55","anna@gmail.com","321234764");
		Customer temp2 = new Customer("Michał","Nowak","Słupsk Szczecinska 21","michal@gmail.com","567343223");
		Customer temp3 = new Customer("Maria","Wiśniewska","Gdańsk Wczasowa 5a","maria@gmail.com","690213433");
		Customer temp4 = new Customer("Piotr","Dąbrowski","Szczecin Gdanska 1","piotr@gmail.com","722900123");
		Customer temp5 = new Customer("Katarzyna","Lewandowska","Kraków Nowogród 11b","katarzyna@gmail.com","577123099");

		System.out.println("Saving new customers...");
		appService.saveCustomer(temp1);
		appService.saveCustomer(temp2);
		appService.saveCustomer(temp3);
		appService.saveCustomer(temp4);
		appService.saveCustomer(temp5);
		System.out.println("Done.");
	}

	private void saveNewCar(AppService appService) {
		List<CarEngine> engineList = appService.findAllEngines();
		Car car = new Car(engineList.getFirst(), "Audi", "A4 B8", 29500,
				2017, 133400, "manualna", "czarny",
				false, "Dobre auto kontak tel: 123456789");
		System.out.println("Saving car...");
		appService.saveCar(car);
		System.out.println("Car successfuly saved.");
		System.out.println(appService.findAllCars());

	}

}
