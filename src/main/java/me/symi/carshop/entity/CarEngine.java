package me.symi.carshop.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class CarEngine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "horsepower")
    private int horsePower;
    @Column(name = "capacity")
    private float capacity;
    @Column(name = "fuel_type")
    private String fuelType;
    @Column(name = "created_at")
    private Timestamp createdAt;

    public CarEngine() {

    }

    public CarEngine(String name, int horsePower, float capacity, String fuelType) {
        this.name = name;
        this.horsePower = horsePower;
        this.capacity = capacity;
        this.fuelType = fuelType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "CarEngine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", horsePower=" + horsePower +
                ", capacity=" + capacity +
                ", fuelType='" + fuelType + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
