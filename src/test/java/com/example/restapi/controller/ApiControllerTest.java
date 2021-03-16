package com.example.restapi.controller;

import com.example.restapi.model.Product;
import com.example.restapi.service.ProductRepoService;
import com.example.restapi.service.ProductRepoServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApiControllerTest {

    @Autowired
    ApiController apiController;

    @Test
    public void shouldReturnListOfProduct() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertFalse(apiController.getAllProduct().getBody().isEmpty());
    }

    @Test
    public void shouldReturnProductWithId() {
        UUID id = UUID.randomUUID();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals(apiController.getProductById(id).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void shouldAddProductId() {
        MockHttpServletRequest request = new MockHttpServletRequest();
    }
}
