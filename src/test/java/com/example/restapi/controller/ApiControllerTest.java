package com.example.restapi.controller;

import com.example.restapi.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApiControllerTest {

    @Autowired
    ApiController apiController;

    @Test
    public void shouldReturnListOfProductAfterAdding() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        Product product = new Product("test", 12.0);
        apiController.addProduct(product);
        ResponseEntity<List<Product>> responseEntity = apiController.getAllProduct();
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertFalse(responseEntity.getBody().isEmpty());
        assertEquals(responseEntity.getBody().get(0).getName(), product.getName());
        assertEquals(responseEntity.getBody().get(0).getPrice(), product.getPrice());
    }

    @Test
    public void shouldReturnProductWithId() {
        UUID id = UUID.randomUUID();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals(apiController.getProductById(id).getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Test
    public void shouldAddProductId() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        Product product = new Product("test", 12.0);
        ResponseEntity<Product> responseEntity = apiController.addProduct(product);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
        assertEquals(responseEntity.getBody().getName(), product.getName());
        assertEquals(responseEntity.getBody().getPrice(), product.getPrice());
        assertFalse(Optional.of(responseEntity.getBody().getId()).isEmpty());

    }

    @Test
    public void shouldUpdateProduct() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        Product product = new Product("test", 12.0);
        apiController.addProduct(product);
        Product updatedProd = product;
        updatedProd.setName("test2");
        ResponseEntity<Product> responseEntity = apiController.updateProduct(product);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(responseEntity.getBody().getName(), updatedProd.getName());
        assertEquals(responseEntity.getBody().getPrice(), updatedProd.getPrice());
        assertEquals(responseEntity.getBody().getId(), product.getId());

    }

    @Test
    public void shouldDeleteProductById() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        Product product = new Product("test", 12.0);
        ResponseEntity<Product> prd = apiController.addProduct(product);
        ResponseEntity<Product> responseEntity = apiController.deleteProductById(prd.getBody().getId());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }
}
