package com.example.restapi.service;

import com.example.restapi.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

@Service
public class ProductRepoServiceImpl implements ProductRepoService{
    List<Product> repo = new ArrayList<Product>();

    @Override
    public List<Product> getAllProducts() {
        return repo;
    }

    @Override
    public Optional<Product> getProductBy(UUID id) {
        Predicate<Product> uuidPredicateFunction = x -> x.getId().equals(id);
        return repo.stream().filter(uuidPredicateFunction).findAny();
    }

    @Override
    public Optional<Product> addProduct(Product product) {
        Product np = new Product(product.getName(), product.getPrice());
        repo.add(np);
        return getProductBy(np.getId());
    }

    public boolean deleteProductBy(Product product) {
         return repo.remove(product);
    }

    @Override
    public Optional<Product> updateProduct(Product product) {
        Optional<Product> prd = getProductBy(product.getId());
        prd.map(prod -> {
            prod.setName(product.getName());
            prod.setPrice(product.getPrice());
            repo.add(prod);
            return true;
        }).orElse(repo.add(product));
        return getProductBy(product.getId());
    }
}
