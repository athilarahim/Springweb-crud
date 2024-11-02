package com.example.Ecommerce.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ecommerce.Model.Products;
import com.example.Ecommerce.Service.ProductService;


@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Products> fetchProducts(){
        return service.getproducts();
    }

    @GetMapping("/products/{prodId}")
    public Products fetchProductById(@PathVariable int prodId){
        return service.getProductsById(prodId);
    }

    @PostMapping("/products")
    public void addProducts(@RequestBody Products prod){
        service.addProduct(prod);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Products prod){
        service.updateProduct(prod);
    }

    @DeleteMapping("/products/{prodId}")
    public void removeProduct(@PathVariable int prodId){
        service.deleteProduct(prodId);
    }
}
