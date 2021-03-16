# java-springboot-rest-api-curd

We can start the application by running the RestapiApplication.java
It will start the application on port 8080.

We have following REST api options:

1. GET All Product: /product
2. GET Product by Id: /product/{id} -- need to pass UUID
3. POST Create Product: /product -- need to pass the body as 
      {
          "id": "",
          "name": "p1",
          "price": 123.00
      }
4. PUT to update the Product /product -- need to pass the body
      {
          "id": "fc7eb54e-9722-4942-af11-7af7e7e5df19",
          "name": "p1",
          "price": 123.0
      }
      
5. DELETE product /product/{id} -- need to pass UUID      
