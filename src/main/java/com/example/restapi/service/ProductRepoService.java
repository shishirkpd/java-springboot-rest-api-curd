package com.example.restapi.service;

import com.example.restapi.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepoService {
    List<Product> getAllProducts();
    Product getProductBy(UUID id);
    UUID addProduct(Product product);

    UUID deleteProductById(UUID id);

    Product updateProduct(Product product);
}
