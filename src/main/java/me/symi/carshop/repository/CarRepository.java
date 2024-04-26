package me.symi.carshop.repository;

import me.symi.carshop.entity.Car;
import me.symi.carshop.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("SELECT c.id FROM Car c ORDER BY RAND() LIMIT 1")
    int findRandomCarId();
    @Query("SELECT c FROM Car c ORDER BY RAND() LIMIT 12")
    List<Car> findTwentyRandomCars();
}
