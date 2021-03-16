package com.example.restapi.service;

import com.example.restapi.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductRepoServiceImpl implements ProductRepoService{
    List<Product> repo = new ArrayList<Product>();

    @Override
    public List<Product> getAllProducts() {
        return repo;
    }

    @Override
    public Product getProductBy(UUID id) {
        return repo.stream().filter(x -> x.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    public UUID addProduct(Product product) {
        Product np = new Product(product.getName(), product.getPrice());
        repo.add(np);
        return np.getId();
    }

    @Override
    public UUID deleteProductById(UUID id) {
        Product product = getProductBy(id);
        repo.remove(product);
       return getProductBy(id).getId();
    }

    @Override
    public Product updateProduct(Product product) {
        Product prod = getProductBy(product.getId());
        prod.setName(product.getName());
        prod.setPrice(product.getPrice());
        repo.add(prod);
        return getProductBy(product.getId());
    }
}
