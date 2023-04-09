package com.cooperatives.produitEtUtilisateurs.services;

import com.cooperatives.produitEtUtilisateurs.models.Product;
import com.cooperatives.produitEtUtilisateurs.repository.ProductRepository;

import jakarta.inject.Inject;
import java.util.List;

public class ProductService {

    @Inject
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id);
        if (existingProduct != null) {
            product.setId(id);
            return productRepository.update(product);
        }
        return null;
    }

    public boolean deleteProduct(Long id) {
        Product product = productRepository.findById(id);
        if (product != null) {
            productRepository.delete(product);
            return true;
        }
        return false;
    }}
