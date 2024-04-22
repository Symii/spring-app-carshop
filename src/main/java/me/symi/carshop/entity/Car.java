package me.symi.carshop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "engine_id")
    private CarEngine carEngine;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "price")
    private int price;
    @Column(name = "year_produced")
    private int yearProduced;
    @Column(name = "mileage")
    private int mileage;
    @Column(name = "gear_type")
    private String gearType;
    @Column(name = "color")
    private String color;
    @Column(name = "damaged")
    private boolean damaged;
    @Column(name = "description")
    private String description;

    public Car() {

    }

    public Car(CarEngine carEngine, String brand, String model, int price, int yearProduced, int mileage, String gearType, String color, boolean damaged, String description) {
        this.carEngine = carEngine;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.yearProduced = yearProduced;
        this.mileage = mileage;
        this.gearType = gearType;
        this.color = color;
        this.damaged = damaged;
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

    public int getYearProduced() {
        return yearProduced;
    }

    public void setYearProduced(int yearProduced) {
        this.yearProduced = yearProduced;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
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
                ", yearProduced=" + yearProduced +
                ", mileage=" + mileage +
                ", gearType='" + gearType + '\'' +
                ", color='" + color + '\'' +
                ", damaged=" + damaged +
                ", description='" + description + '\'' +
                '}';
    }
}
