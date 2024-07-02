package com.first.springfirst.service;

import java.util.List;

import com.first.springfirst.model.Product;


/**
 * CRUD, data persistance 
 */
public interface ProductService {
    
    Product create(Product product);

    List<Product> read();

    Product modify(Long id, Product product);

    String delete(Long id);
}
