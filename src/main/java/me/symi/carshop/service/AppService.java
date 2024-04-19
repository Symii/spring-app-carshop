package me.symi.carshop.service;

import me.symi.carshop.entity.Car;
import me.symi.carshop.entity.CarEngine;
import me.symi.carshop.entity.Customer;
import me.symi.carshop.entity.Order;

import java.util.List;

public interface AppService {

    List<Car> findAllCars();
    Car findCarById(int theId);
    Car saveCar(Car theCar);
    void deleteCarById(int theId);
    CarEngine findEngineById(int theId);
    List<CarEngine> findAllEngines();
    List<Customer> findAllCustomers();
    Customer findCustomerById(int theId);
    Customer saveCustomer(Customer theCustomer);
    void deleteCustomerById(int theId);
    List<Order> findAllOrders();
    Order findOrderById(int theId);
    Order saveOrder(Order theOrder);
    void deleteOrderById(int theId);


}
