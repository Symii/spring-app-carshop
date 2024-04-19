package me.symi.carshop.entity;

import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "engine_id")
    private CarEngine carEngine;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "price")
    private int price;
    @Column(name = "description")
    private String description;

    public Car() {

    }

    public Car(CarEngine carEngine, String brand, String model, int price, String description) {
        this.carEngine = carEngine;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarEngine getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(CarEngine carEngine) {
        this.carEngine = carEngine;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carEngine=" + carEngine +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
