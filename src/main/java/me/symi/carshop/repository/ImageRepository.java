package me.symi.carshop.repository;

import me.symi.carshop.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageEntity, Integer> {

    @Query("SELECT i FROM car_image i WHERE i.car_id = ?1")
    List<ImageEntity> findAllImagesByCarId(int theId);

}
