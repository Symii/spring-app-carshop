package me.symi.carshop.service;

import me.symi.carshop.entity.*;

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
    List<Review> findAllReviews();
    Review findReviewById(int theId);
    Review saveReview(Review theReview);
    void deleteReviewById(int theId);
    List<ImageEntity> findAllImages();
    ImageEntity findImageById(int theId);
    List<ImageEntity> findAllImagesByCar(Car theCar);
    ImageEntity saveImage(ImageEntity theImage);
    void deleteImageById(int theId);

}
