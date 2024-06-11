package me.symi.carshop.service;

import me.symi.carshop.dto.Annouance;
import me.symi.carshop.dto.AnnouanceResponse;
import me.symi.carshop.entity.Car;
import me.symi.carshop.entity.CarEngine;
import me.symi.carshop.entity.Customer;
import me.symi.carshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnnouanceServiceImpl implements AnnouanceService {

    private CarRepository carRepository;

    @Autowired
    public AnnouanceServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    @Transactional
    public AnnouanceResponse addAnnouance(Annouance annouance) {

        Customer customer = annouance.getCustomer();
        CarEngine carEngine = annouance.getCarEngine();
        Car car = annouance.getCar();
        car.setCustomer(customer);
        car.setCarEngine(carEngine);
        
        carRepository.save(car);
        String annouanceLink = getAnnouanceLink(car);
        return new AnnouanceResponse(annouanceLink);
    }

    private String getAnnouanceLink(Car car) {
        return "/car-detail/" + car.getId();
    }
}
