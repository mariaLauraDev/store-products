package com.ada.storeproducts.service;

import com.ada.storeproducts.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

@Service
public class ProductService {

    private ArrayList<Product> products;
    private int productIdentifier;

    public ProductService(int size) {
        products = new ArrayList<>(Collections.nCopies(size, new Product()));
        productIdentifier = 1;
    }

    public void addProduct(String name, String description, Double price, String category) {
        if (productIdentifier > products.size()) {
            throw new RuntimeException("There is no product space");
        }
        products.set(productIdentifier, new Product(productIdentifier, name, description, price, category));
        productIdentifier++;
    }

    public void deleteProduct(int productId) {
        IntStream.range(0, productIdentifier)
                .filter(i -> products.get(i) != null && products.get(i).getId() == productId)
                .findFirst()
                .ifPresent(i -> products.set(i, null));
    }


    public Product getProduct(int productId) {
        return products.stream()
                .filter(product -> product != null && product.getId() == productId)
                .findFirst()
                .orElse(null);
    }

    public List<Product> getProductsByCategory(String category) {
        return products.stream()
                .filter(Objects::nonNull)
                .filter(p -> category.equals(p.getCategory()))
                .collect(Collectors.toList());
    }


}
