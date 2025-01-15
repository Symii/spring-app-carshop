package me.symi.carshop.rest;

import me.symi.carshop.dto.Annouance;
import me.symi.carshop.dto.AnnouanceResponse;
import me.symi.carshop.entity.Car;
import me.symi.carshop.service.AnnouanceService;
import me.symi.carshop.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://symii.github.io")
public class CarRestController {

    private AppService appService;
    private AnnouanceService annouanceService;

    @Autowired
    public CarRestController(AppService appService, AnnouanceService annouanceService) {
        this.appService = appService;
        this.annouanceService = annouanceService;
    }

    @PostMapping("/annouance/new")
    public AnnouanceResponse addNewAnnouance(@RequestBody Annouance annouance) {
        AnnouanceResponse annouanceResponse = annouanceService.addAnnouance(annouance);
        return annouanceResponse;
    }

    @GetMapping("/cars")
    public List<Car> printAllCars(@RequestParam(defaultValue = "12") int maxRows) {
        Pageable pageable = PageRequest.of(0, maxRows);
        return appService.findAllCarsPageable(pageable);
    }

    @GetMapping("/cars/random")
    public List<Car> printRandomCars() {
        return appService.findTwentyRandomCars();
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
        String sql = "SELECT c.id, c.brand, c.color, " +
                "c.damaged, c.description, c.gear_type, c.mileage," +
                "c.model, c.price, c.year_produced, c.body, c.engine_id, c.customer_id," +
                "engine.capacity, engine.fuel_type, engine.horsepower " +
                "FROM car c " +
                "JOIN engine ON c.engine_id = engine.id " +
                "WHERE 1=1";
        if(brand != null && !brand.equals("any")) {
            sql += " AND c.brand LIKE '%"+brand+"%'";
        }
        if(body != null) {
            sql += " AND c.body LIKE '%"+body+"%'";
        }
        if(priceFrom != null) {
            sql += " AND c.price > " + priceFrom;
        }
        if(priceTo != null) {
            sql += " AND c.price < " + priceTo;
        }
        if(yearProducedFrom != null) {
            sql += " AND c.year_produced >= " + yearProducedFrom;
        }
        if(fuelType != null) {
            sql += " AND engine.fuel_type = '"+fuelType+"'";
        }
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
