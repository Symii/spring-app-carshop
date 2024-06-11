package me.symi.carshop.service;

import me.symi.carshop.entity.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AppService {

    List<Car> findTwentyRandomCars();
    List<Car> findCarsByFilter(String sql);
    List<Car> findCarsByKeyword(String theKeyword);
    List<Car> findAllCars();
    List<Car> findAllCarsPageable(Pageable pageable);
    Car findCarById(int theId);
    List<Car> getTwentyRandomCars();
    Car saveCar(Car theCar);
    void deleteCarById(int theId);
    CarEngine findEngineById(int theId);
    List<CarEngine> findAllEngines();
    List<Customer> findAllCustomers();
    Customer findCustomerById(int theId);
    Customer findCustomerByEmail(String email);
    Customer saveCustomer(Customer theCustomer);
    void deleteCustomerById(int theId);
    List<Review> findAllReviews();
    Review findReviewById(int theId);
    Review saveReview(Review theReview);
    void deleteReviewById(int theId);
    List<ImageEntity> findAllImages();
    ImageEntity findImageById(int theId);
    List<ImageEntity> findAllImagesByCar(Car theCar);
    ImageEntity saveImage(ImageEntity theImage);
    void deleteImageById(int theId);
    List<CarEngine> findAllCarEngines();
    CarEngine findCarEngineById(int theId);
    CarEngine saveCarEngine(CarEngine theCar);
    void deleteCarEngineById(int theId);

}
