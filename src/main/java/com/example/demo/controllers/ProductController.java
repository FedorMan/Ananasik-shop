package com.example.demo.controllers;

import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller()
@RequestMapping("controller/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @RequestMapping("/save")
    public ResponseEntity save(RequestEntity<Product> requestEntity){
        Product product = requestEntity.getBody();
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping("/all")
    public @ResponseBody List<Product> all(){
        return productRepository.findAll();
    }

    @RequestMapping("/delete")
    public ResponseEntity delete(@RequestParam("id") Long id){
        productRepository.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
