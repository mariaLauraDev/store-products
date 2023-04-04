package com.ada.storeproducts.service;

import com.ada.storeproducts.model.Product;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class StockService {

    private final ProductService productService;

    public  StockService(ProductService productService) {
        this.productService = productService;
    }

    public void addStock (int productId, int quantity){
        Product product = productService.getProduct(productId);
        product.setStock((product.getStock() + quantity));
    }
    public void deleteStock (int productId, int quantity){
        Product product = productService.getProduct(productId);
        int newStock = product.getStock() - quantity;
        if (newStock < 0) {
            throw new RuntimeException("Insufficient stock");
        }
        product.setStock(newStock);
    }

}
