package com.example.restapi.controller;

import com.example.restapi.model.Product;
import com.example.restapi.service.ProductRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ApiController {

    @Autowired
    ProductRepoService productRepoService;


    @GetMapping(value = "/product/{id}")
    public Product getProductById(@PathVariable UUID id) {
        return productRepoService.getProductBy(id);
    }

    @GetMapping("/product")
    public List<Product> getAllProduct(){
        return productRepoService.getAllProducts();
    }

    @PostMapping("/product")
    public UUID addProduct(@RequestBody Product product){
        return productRepoService.addProduct(product);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product){
        return productRepoService.updateProduct(product);
    }

    @DeleteMapping(value = "/product/{id}")
    public void deleteProductById(@PathVariable UUID id) {
        productRepoService.deleteProductById(id);
    }
}
