package me.symi.carshop.rest;

import me.symi.carshop.entity.Car;
import me.symi.carshop.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CarRestController {

    private AppService appService;

    @Autowired
    public CarRestController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/cars")
    public List<Car> printAllCars(@RequestParam(defaultValue = "12") int maxRows) {
        Pageable pageable = PageRequest.of(0, maxRows);
        return appService.findAllCarsPageable(pageable);
    }

    @GetMapping("/cars/{carId}")
    public Car getSingleCar(@PathVariable int carId) {
        Car car = appService.findCarById(carId);
        if(car == null) {
            throw new CarNotFoundException("Car id not found - " + carId);
        }
        return car;
    }

    @PostMapping("/cars")
    public Car addCar(@RequestBody Car theCar) {
        theCar.setId(0);
        return appService.saveCar(theCar);
    }

    @PutMapping("/cars")
    public Car updateCar(@RequestBody Car theCar) {
        return appService.saveCar(theCar);
    }

    @DeleteMapping("/cars/{carId}")
    public String deleteCar(@PathVariable int carId) {
        Car car = appService.findCarById(carId);

        if(car == null) {
            throw new CarNotFoundException("Car not found id - " + carId);
        }
        appService.deleteCarById(carId);
        return "Deleted car id - " + carId;
    }



}
