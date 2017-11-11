package com.example.demo.controllers;


import com.example.demo.model.Product;
import com.example.demo.model.Seller;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.time.LocalDate;
import java.util.List;


@RestController
public class MainController {

    @Autowired
    SellersRepository sellerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    SaleRepositiry saleRepositiry;

    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("product.html");
    }

    @RequestMapping("/addSaller")
    public void addCategory(){

        sellerRepository.save(new Seller("Anastasia", "Lagarnikova", "Vakilevna",
                LocalDate.of(1996,7,23), LocalDate.of(2017,10,7), "lagarnas@gmail.com", "89179511739", "Novo-Sadovaya"));
    }

    @RequestMapping("/getAllSellers")
    public Iterable<Seller> getAll() {
        return sellerRepository.findAll();
    }

    @RequestMapping("/saveProduct")
    public void saveProduct(RequestEntity<Product> requestEntity){
        Product product = requestEntity.getBody();
        productRepository.save(product);
    }

    @RequestMapping("/getProducts")
    public List<Product> getProducts(RequestEntity<Product> requestEntity){
        return productRepository.findAll();
    }

    @RequestMapping("/deleteProduct")
    public void deleteProduc(@RequestParam("id") Long id){
        productRepository.delete(id);
    }

}
