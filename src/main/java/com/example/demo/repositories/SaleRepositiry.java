package com.example.demo.repositories;

import com.example.demo.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepositiry extends JpaRepository<Sale,Long>{
}
