package me.symi.carshop.repository;

import me.symi.carshop.entity.CarEngine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarEngineRepository extends JpaRepository<CarEngine, Integer> {
}
