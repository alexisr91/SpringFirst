package com.first.springfirst.controller;

import org.springframework.web.bind.annotation.RestController;

import com.first.springfirst.model.Product;
import com.first.springfirst.service.ProductService; 
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;






@RestController
@RequestMapping("/product")
@RequiredArgsConstructor

/**
 * Controller side that will interact with the model and the view 
 */
public class ProductController {
    
    // Inversion of Control
    private final ProductService productService;

    // POSTMAN 
    @GetMapping
    public String greeting(){
        return "Hello";
    }

    @PostMapping("/create")
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @GetMapping("/read")
    public List<Product> read(){
        return productService.read();
    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable Long id, Product product){
        return productService.modify(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return productService.delete(id);
    }
}
