package me.symi.carshop.repository;

import me.symi.carshop.entity.Car;
import me.symi.carshop.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageEntity, Integer> {

    @Query("SELECT i FROM ImageEntity i WHERE i.car = :car")
    List<ImageEntity> findAllImagesByCar(@Param("car") Car car);

}
