package com.example.demo.repositories;

import com.example.demo.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellersRepository extends JpaRepository<Seller,Long> {
}
