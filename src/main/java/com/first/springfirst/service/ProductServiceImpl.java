package com.first.springfirst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.springfirst.model.Product;
import com.first.springfirst.repository.ProductRepository;


@Service
/**
 * Business logic part that interacts with the persistance side ( Product service )
 */
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> read() {
        return productRepository.findAll();
    }

    @Override
    public Product modify(Long id, Product product) {
    
            return productRepository.findById(id)
                    .map(p->{
                        p.setPrice(product.getPrice());
                        p.setName(product.getName());
                        p.setDescription(product.getDescription());
                        return productRepository.save(p);
                    }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public String delete(Long id) {
            productRepository.deleteById(id);
            return "Product deleted";
    }
}
