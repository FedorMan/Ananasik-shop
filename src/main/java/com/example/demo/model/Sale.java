package com.example.demo.model;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;

    @ManyToOne(targetEntity = Product.class)
    private Product product;

    private Integer mincount;
    private Double priceunity;

    @Type(type="org.hibernate.type.LocalDateType")
    LocalDate startdate;

    @Type(type="org.hibernate.type.LocalDateType")
    LocalDate enddate;

    public Sale() {
    }

    public Sale(Customer customer, Product product, Integer mincount, Double priceunity, LocalDate startdate, LocalDate enddate) {
        this.customer = customer;
        this.product = product;
        this.mincount = mincount;
        this.priceunity = priceunity;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getMincount() {
        return mincount;
    }

    public void setMincount(Integer mincount) {
        this.mincount = mincount;
    }

    public Double getPriceunity() {
        return priceunity;
    }

    public void setPriceunity(Double priceunity) {
        this.priceunity = priceunity;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", customer=" + customer +
                ", product=" + product +
                ", mincount=" + mincount +
                ", priceunity=" + priceunity +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                '}';
    }
}
