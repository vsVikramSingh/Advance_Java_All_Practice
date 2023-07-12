package com.cdac.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.training.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
