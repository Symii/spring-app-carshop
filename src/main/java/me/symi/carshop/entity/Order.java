package me.symi.carshop.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToOne()
    @JoinColumn(name = "car_id")
    private Car car;
    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp orderDate;

    public Order() {

    }

    public Order(Customer customer, Car car) {
        this.customer = customer;
        this.car = car;
        orderDate = new Timestamp(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", car=" + car +
                ", orderDate=" + orderDate +
                '}';
    }
}
