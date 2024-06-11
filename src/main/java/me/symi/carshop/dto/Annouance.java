package me.symi.carshop.dto;

import me.symi.carshop.entity.Car;
import me.symi.carshop.entity.CarEngine;
import me.symi.carshop.entity.Customer;

public class Annouance {

    private Car car;
    private CarEngine carEngine;
    private Customer customer;

    public Annouance(Car car, CarEngine carEngine, Customer customer) {
        this.car = car;
        this.carEngine = carEngine;
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public CarEngine getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(CarEngine carEngine) {
        this.carEngine = carEngine;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
