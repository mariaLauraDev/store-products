package com.ada.storeproducts.service;

import com.ada.storeproducts.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class StockServiceTest {

    private ProductService productServiceMock;
    private Product productMock;

    @BeforeEach
    public void setUp() {
        productServiceMock = mock(ProductService.class);
        productMock = mock(Product.class);
    }

    @Test
    public void addStockTest() {
        //given
        StockService stockService = new StockService(productServiceMock);
        when(productServiceMock.getProduct(1)).thenReturn(productMock);
        when(productMock.getStock()).thenReturn(5);

        //when
        stockService.addStock(1, 5);

        //then
        verify(productMock).setStock(10);
    }

    @Test

    public void deleteStockExceptionTest() {
        //given
        StockService stockService = new StockService(productServiceMock);
        when(productServiceMock.getProduct(1)).thenReturn(productMock);
        when(productMock.getStock()).thenReturn(2);

        //when and then
        Assertions.assertThrows(RuntimeException.class, () -> {
            stockService.deleteStock(1,3);
        });
    }




}
