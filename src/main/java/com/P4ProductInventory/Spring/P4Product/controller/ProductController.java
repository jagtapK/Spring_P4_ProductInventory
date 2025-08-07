package com.P4ProductInventory.Spring.P4Product.controller;

import com.P4ProductInventory.Spring.P4Product.entity.Product;
import com.P4ProductInventory.Spring.P4Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody List<Product> product) {

        product.forEach(product1 -> {
            System.err.println(product1);
            productService.saveProduct(product1);
        });

        return new ResponseEntity<>("Save details Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/GetAllProduct")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> ProductList = productService.getAllProducts();
        return new ResponseEntity<>(ProductList, HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<Product> getEmployeeById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/DeleteById/{id}")
    public ResponseEntity<String> DeleteById(@PathVariable int id) {
        String product = productService.deletedById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/UpdateById/{id}")
    public ResponseEntity<Product> updateById(@PathVariable int id,@RequestBody Product product){
        Product product1 =  productService.UpdateById(id,product);
        return new ResponseEntity<>(product1,HttpStatus.OK);
    }
}
