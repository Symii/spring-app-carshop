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

    @GetMapping("/cars/search/findByKeyword")
    public List<Car> findByNameContaining(@RequestParam String keyword) {
        return appService.findCarsByKeyword(keyword);
    }

    @GetMapping("/cars/filter")
    public List<Car> findCarsWithFilter(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size,
                                        @RequestParam(required = false) String brand,
                                        @RequestParam(required = false) String body,
                                        @RequestParam(required = false) String priceFrom,
                                        @RequestParam(required = false) String priceTo,
                                        @RequestParam(required = false) String yearProducedFrom,
                                        @RequestParam(required = false) String fuelType)
    {
        String sql = "SELECT * FROM Car c WHERE 1=1";
        if(brand != null && !brand.equals("any")) {
            sql += " AND c.brand LIKE \"%"+brand+"%\"";
        }
        // TODO: body
        if(priceFrom != null) {
            sql += " AND c.price > " + priceFrom;
        }
        if(priceTo != null) {
            sql += " AND c.price < " + priceTo;
        }
        // TODO: yearFrom
        // TODO: fuelType
        sql += " LIMIT " + size;
        return appService.findCarsByFilter(sql);
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
