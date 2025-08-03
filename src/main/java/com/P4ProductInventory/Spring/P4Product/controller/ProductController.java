package com.P4ProductInventory.Spring.P4Product.controller;

import com.P4ProductInventory.Spring.P4Product.entity.Product;
import com.P4ProductInventory.Spring.P4Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody List<Product> product){

        product.forEach(product1 -> {
            System.err.println(product1);
            productService.saveProduct(product1);
        });

        return new ResponseEntity<>("Save details Successfully", HttpStatus.CREATED);
    }

}
