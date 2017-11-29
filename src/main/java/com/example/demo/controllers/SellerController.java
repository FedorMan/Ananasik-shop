package com.example.demo.controllers;

import com.example.demo.model.Seller;
import com.example.demo.repositories.SellersRepository;
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
@RequestMapping("controller/seller")
public class SellerController {
    @Autowired
    SellersRepository sellerRepository;
    @RequestMapping("/save")
    public ResponseEntity save(RequestEntity<Seller> requestEntity){
        Seller seller = requestEntity.getBody();
        sellerRepository.save(seller);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping("/all")
    public @ResponseBody List<Seller> all() {
        return sellerRepository.findAll();
    }

    @RequestMapping("/delete")
    public ResponseEntity delete(@RequestParam("id") Long id){
        sellerRepository.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
