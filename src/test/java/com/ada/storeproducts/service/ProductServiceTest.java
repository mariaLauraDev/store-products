package com.ada.storeproducts.service;

import com.ada.storeproducts.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductServiceTest {

    @Test
    public void addProductCorrectlyTest() {
        //given
        ProductService productService = new ProductService(5);

        //when
        productService.addProduct("Case Harry Potter", "A case for your cell phone to remind you of your hogwarts house", 99.90, "case");

        //then
        Assertions.assertEquals(1, productService.getProduct(1).getId());
    }

    @Test
    public void deleteProductCorrectlyTest() {
        //given
        ProductService productService = new ProductService(5);
        productService.addProduct("Case Harry Potter Gryffindor", "A case for your cell phone to remind you that your hogwarts house is gryffindor", 99.90, "case");
        productService.addProduct("Case Harry Potter Ravenclaw", "A case for your cell phone to remind you that your hogwarts house is ravenclaw", 99.90, "case");

        //when
       productService.deleteProduct(2);

        //then
        Assertions.assertNull(productService.getProduct(2));
    }

    @Test
    public void getProductCorrectlyTest() {
        //given
        ProductService productService = new ProductService(5);
        productService.addProduct("Case Harry Potter Gryffindor", "A case for your cell phone to remind you that your hogwarts house is gryffindor", 99.90, "case");

        //when
        Product product = productService.getProduct(1);

        //then
        Assertions.assertNotNull(product);
        Assertions.assertEquals(1,product.getId());
        Assertions.assertEquals("Case Harry Potter Gryffindor", product.getName());
        Assertions.assertEquals("A case for your cell phone to remind you that your hogwarts house is gryffindor", product.getDescription());
        Assertions.assertEquals(99.90, product.getPrice());
        Assertions.assertEquals("case", product.getCategory());
    }

    @Test
    public void addProductExceptionCorrectlyTest() {
        //given
        ProductService productService = new ProductService(2);

        //when
        productService.addProduct("Case Harry Potter Gryffindor", "A case for your cell phone to remind you that your hogwarts house is gryffindor", 99.90, "case");

        //then
        assertThrows(RuntimeException.class, () -> {
            productService.addProduct("Case Harry Potter Ravenclaw", "A case for your cell phone to remind you that your hogwarts house is ravenclaw", 99.90, "case");
        });
    }

    @Test
    public void getProductsByCategoryCorrectlyTest() {
        //given
        ProductService productService = new ProductService(5);
        productService.addProduct("Case Harry Potter Gryffindor", "A case for your cell phone to remind you that your hogwarts house is gryffindor", 99.90, "case");
        productService.addProduct("Case Harry Potter Ravenclaw", "A case for your cell phone to remind you that your hogwarts house is ravenclaw", 99.90, "case");
        productService.addProduct("Bag Harry Potter Gryffindor", "A bag for your trip to remind you that your hogwarts house is gryffindor", 299.90, "bag");
        productService.addProduct("Bag Harry Potter Ravenclaw", "A bag for your trip to remind you that your hogwarts house is ravenclaw", 299.90, "bag");

        //when
       ArrayList<Product> producsFiltered = new ArrayList<>(productService.getProductsByCategory("case"));

        //then
        assertEquals(2, producsFiltered.size());
    }

}
