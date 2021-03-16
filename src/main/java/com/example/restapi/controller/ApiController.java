package com.example.restapi.controller;

import com.example.restapi.model.Product;
import com.example.restapi.service.ProductRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ApiController {

    @Autowired
    ProductRepoService productRepoService;


    @GetMapping(value = "/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable UUID id) {
        Optional<Product> product = productRepoService.getProductBy(id);
        return product
                .map(x -> new ResponseEntity(x,HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProduct(){
      return new ResponseEntity<>(productRepoService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Optional<Product> prod = productRepoService.addProduct(product);
        return prod
                .map(prd -> new ResponseEntity<>(prd, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Optional<Product> prod = productRepoService.updateProduct(product);
        return prod.map(x -> new ResponseEntity(x,HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity deleteProductById(@PathVariable UUID id) {
        return productRepoService.getProductBy(id).map(prd -> {
            boolean res = productRepoService.deleteProductBy(prd);
            if(res)
                return new ResponseEntity("Id: "+ id + "is deleted", HttpStatus.OK);
            else
                return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);}
        ).orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }
}
