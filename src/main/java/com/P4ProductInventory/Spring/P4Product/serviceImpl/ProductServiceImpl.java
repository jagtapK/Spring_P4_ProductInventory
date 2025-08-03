package com.P4ProductInventory.Spring.P4Product.serviceImpl;

import com.P4ProductInventory.Spring.P4Product.entity.Product;
import com.P4ProductInventory.Spring.P4Product.repository.ProductRepository;
import com.P4ProductInventory.Spring.P4Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public String saveProduct(Product product) {

        Product saveProduct = productRepository.save(product);
        return "Product Details saved";
    }
}
