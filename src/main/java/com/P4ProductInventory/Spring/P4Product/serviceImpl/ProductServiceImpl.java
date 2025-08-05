package com.P4ProductInventory.Spring.P4Product.serviceImpl;

import com.P4ProductInventory.Spring.P4Product.entity.Product;
import com.P4ProductInventory.Spring.P4Product.repository.ProductRepository;
import com.P4ProductInventory.Spring.P4Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public String saveProduct(Product product) {

        Product saveProduct = productRepository.save(product);
        return "Product Details saved";
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> allProduct = productRepository.findAll();
        return allProduct;
    }

    @Override
    public Product getProductById(int id) {
        Product ProductById = productRepository.findById(id).orElseThrow(()
        -> new NullPointerException("Product id is not found"+id));
        return ProductById;
    }

    @Override
    public String deletedById(int id) {
        productRepository.deleteById(id);
        return "Product Data Deleted";
    }
}
