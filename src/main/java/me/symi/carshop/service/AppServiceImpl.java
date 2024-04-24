package me.symi.carshop.service;

import me.symi.carshop.entity.*;
import me.symi.carshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppServiceImpl implements AppService {

    private final CarRepository carRepository;
    private final CarEngineRepository carEngineRepository;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ReviewRepository reviewRepository;
    private final ImageRepository imageRepository;

    @Autowired
    public AppServiceImpl(CarRepository carRepository, CarEngineRepository carEngineRepository,
                      CustomerRepository customerRepository, OrderRepository orderRepository,
                      ReviewRepository reviewRepository, ImageRepository imageRepository) {
        this.carRepository = carRepository;
        this.carEngineRepository = carEngineRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.reviewRepository = reviewRepository;
        this.imageRepository = imageRepository;
    }


    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
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
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order findOrderById(int theId) {
        Optional<Order> orderOptional = orderRepository.findById(theId);

        Order order = null;
        if(orderOptional.isPresent()) {
            order = orderOptional.get();
        } else {
            throw new RuntimeException("Did not find order id - " + theId);
        }

        return order;
    }

    @Override
    public Order saveOrder(Order theOrder) {
        return orderRepository.save(theOrder);
    }

    @Override
    public void deleteOrderById(int theId) {
        orderRepository.deleteById(theId);
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
}
