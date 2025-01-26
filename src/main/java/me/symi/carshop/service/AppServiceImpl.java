package me.symi.carshop.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import me.symi.carshop.entity.*;
import me.symi.carshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppServiceImpl implements AppService {

    private final CarRepository carRepository;
    private final CarEngineRepository carEngineRepository;
    private final CustomerRepository customerRepository;
    private final ReviewRepository reviewRepository;
    private final ImageRepository imageRepository;
    private final EntityManager entityManager;

    @Autowired
    public AppServiceImpl(EntityManager entityManager, CarRepository carRepository, CarEngineRepository carEngineRepository,
                      CustomerRepository customerRepository,
                      ReviewRepository reviewRepository, ImageRepository imageRepository) {
        this.entityManager = entityManager;
        this.carRepository = carRepository;
        this.carEngineRepository = carEngineRepository;
        this.customerRepository = customerRepository;
        this.reviewRepository = reviewRepository;
        this.imageRepository = imageRepository;
    }


    @Override
    public List<Car> findCarsByFilter(String sql) {
        Query query = entityManager.createNativeQuery(sql, Car.class);
        return query.getResultList();
    }

    @Override
    public List<Car> findCarsByKeyword(String theKeyword) {
        return carRepository.findCarsByKeyword(theKeyword);
    }
    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> findAllCarsPageable(Pageable pageable) {
        return carRepository.findAll(pageable).stream().toList();
    }

    @Override
    public List<Car> findTwentyRandomCars() {
        return carRepository.findTwentyRandomCars();
    }

    @Override
    public Car findCarById(int theId) {
        Optional<Car> carOptional = carRepository.findById(theId);

        Car car = null;
        if(carOptional.isPresent()) {
            car = carOptional.get();
        } else {
            throw new RuntimeException("Did not find car id - " + theId);
        }

        return car;
    }

    // TODO: Please change this in production as it generates significant load (preview function).
    @Override
    public List<Car> getTwentyRandomCars() {
        List<Car> randomCars = new ArrayList<>();
        for(int i = 1; i <= 12; i++) {
            randomCars.add(findCarById(carRepository.findRandomCarId()));
        }

        return randomCars;
    }

    /*
    @Override
    public List<Car> getTwentyRandomCars() {
        return carRepository.findTwentyRandomCars();
    }*/

    @Override
    public Car saveCar(Car theCar) {
        return carRepository.save(theCar);
    }

    @Override
    public void deleteCarById(int theId) {
        carRepository.deleteById(theId);
    }

    @Override
    public CarEngine findEngineById(int theId) {
        Optional<CarEngine> carEngineOptional = carEngineRepository.findById(theId);

        CarEngine engine = null;
        if(carEngineOptional.isPresent()) {
            engine = carEngineOptional.get();
        } else {
            throw new RuntimeException("Did not find engine id - " + theId);
        }

        return engine;
    }

    @Override
    public List<CarEngine> findAllEngines() {
        return carEngineRepository.findAll();
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(int theId) {
        Optional<Customer> customerOptional = customerRepository.findById(theId);

        Customer customer = null;
        if(customerOptional.isPresent()) {
            customer = customerOptional.get();
        } else {
            throw new RuntimeException("Did not find customer id - " + theId);
        }

        return customer;
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    @Override
    public Customer saveCustomer(Customer theCustomer) {
        return customerRepository.save(theCustomer);
    }

    @Override
    public void deleteCustomerById(int theId) {
        customerRepository.deleteById(theId);
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findReviewById(int theId) {
        Optional<Review> reviewOptional = reviewRepository.findById(theId);

        Review review = null;
        if(reviewOptional.isPresent()) {
            review = reviewOptional.get();
        } else {
            throw new RuntimeException("Did not find review id - " + theId);
        }

        return review;
    }

    @Override
    public Review saveReview(Review theReview) {
        return reviewRepository.save(theReview);
    }

    @Override
    public void deleteReviewById(int theId) {
        reviewRepository.deleteById(theId);
    }

    @Override
    public List<ImageEntity> findAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public ImageEntity findImageById(int theId) {
        Optional<ImageEntity> imageOptional = imageRepository.findById(theId);

        ImageEntity image = null;
        if(imageOptional.isPresent()) {
            image = imageOptional.get();
        } else {
            throw new RuntimeException("Did not find image id - " + theId);
        }

        return image;
    }

    @Override
    public List<ImageEntity> findAllImagesByCar(Car theCar) {
        return imageRepository.findAllImagesByCar(theCar);
    }

    @Override
    public ImageEntity saveImage(ImageEntity theImage) {
        return imageRepository.save(theImage);
    }

    @Override
    public void deleteImageById(int theId) {
        imageRepository.deleteById(theId);
    }

    @Override
    public List<CarEngine> findAllCarEngines() {
        return carEngineRepository.findAll();
    }

    @Override
    public CarEngine findCarEngineById(int theId) {
        Optional<CarEngine> engineOptional = carEngineRepository.findById(theId);

        CarEngine engine = null;
        if(engineOptional.isPresent()) {
            engine = engineOptional.get();
        } else {
            throw new RuntimeException("Did not find car engine id - " + theId);
        }

        return engine;
    }

    @Override
    public CarEngine saveCarEngine(CarEngine theCar) {
        return carEngineRepository.save(theCar);
    }

    @Override
    public void deleteCarEngineById(int theId) {
        carEngineRepository.deleteById(theId);
    }

    @Override
    public List<String> findAllCarBrands() {
        return carRepository.findAllCarBrands();
    }

    @Override
    public int getCarsCount() {
        return carRepository.getCarsCount();
    }
}
