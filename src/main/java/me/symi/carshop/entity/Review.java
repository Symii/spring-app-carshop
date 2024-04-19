package me.symi.carshop.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(name = "points")
    private short points;
    @Column(name = "review_message")
    private String reviewMessage;
    @Column(name = "created_at")
    private Timestamp createdAt;

    public Review() {

    }

    public Review(Car car, Customer customer, short points, String reviewMessage) {
        this.car = car;
        this.customer = customer;
        this.points = points;
        this.reviewMessage = reviewMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public short getPoints() {
        return points;
    }

    public void setPoints(short points) {
        this.points = points;
    }

    public String getReviewMessage() {
        return reviewMessage;
    }

    public void setReviewMessage(String reviewMessage) {
        this.reviewMessage = reviewMessage;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", car=" + car +
                ", customer=" + customer +
                ", points=" + points +
                ", reviewMessage='" + reviewMessage + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
