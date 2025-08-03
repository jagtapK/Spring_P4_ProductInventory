package com.P4ProductInventory.Spring.P4Product.repository;

import com.P4ProductInventory.Spring.P4Product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
