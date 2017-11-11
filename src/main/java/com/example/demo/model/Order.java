package com.example.demo.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Type(type="org.hibernate.type.LocalDateType")
    private LocalDate startDate;
    @Type(type="org.hibernate.type.LocalDateType")
    private LocalDate endDate;

    @ManyToOne(cascade = CascadeType.REMOVE,targetEntity = Seller.class)
    private Seller seller;
    @ManyToOne(cascade = CascadeType.REMOVE,targetEntity = Customer.class)
    private Customer customer;
    @ManyToOne(cascade = CascadeType.REMOVE,targetEntity = Product.class)
    private Product product;

    private Integer count;
    private Double price;
    private String aboutPrice;
    private String address;

    public Order() {
    }

    public Order(LocalDate startDate, LocalDate endDate, Seller seller, Customer customer, Product product, Integer count, Double price, String aboutPrice, String address) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.seller = seller;
        this.customer = customer;
        this.product = product;
        this.count = count;
        this.price = price;
        this.aboutPrice = aboutPrice;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAboutPrice() {
        return aboutPrice;
    }

    public void setAboutPrice(String aboutPrice) {
        this.aboutPrice = aboutPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", seller=" + seller +
                ", customer=" + customer +
                ", product=" + product +
                ", count=" + count +
                ", price=" + price +
                ", aboutPrice='" + aboutPrice + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
