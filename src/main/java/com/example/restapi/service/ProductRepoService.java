package com.example.restapi.service;

import com.example.restapi.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepoService {
    List<Product> getAllProducts();
    Optional<Product> getProductBy(UUID id);
    Optional<Product> addProduct(Product product);

    boolean deleteProductBy(Product product);

    Optional<Product> updateProduct(Product product);
}
