package com.P4ProductInventory.Spring.P4Product.service;

import com.P4ProductInventory.Spring.P4Product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductService{
    public String saveProduct(Product product);

    public List<Product> getAllProducts();


}
