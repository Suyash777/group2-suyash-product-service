package com.prod.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prod.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	Product findByProductKey(String productKey);
}
