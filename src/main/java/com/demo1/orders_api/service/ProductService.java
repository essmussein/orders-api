package com.demo1.orders_api.service;

import com.demo1.orders_api.domain.Product;
import com.demo1.orders_api.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Page<Product> list(Pageable pageable) {
        return repo.findAll(pageable);
    }

    /*public Product get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + id));
    }*/
    
    public Product get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new com.demo1.orders_api.exception.NotFoundException("Product not found: " + id));
    }

    public Product create(Product p) {
        p.setId(null);
        return repo.save(p);
    }

    public Product update(Long id, Product p) {
        Product existing = get(id);
        existing.setName(p.getName());
        existing.setDescription(p.getDescription());
        existing.setPrice(p.getPrice());
        existing.setStock(p.getStock());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.delete(get(id));
    }
}

